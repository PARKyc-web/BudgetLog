package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.budget.mapper.BudgetMapper;
import io.github.parkyc.budgetlog.budget.repository.BudgetMemberRepository;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BudgetServiceImpl implements BudgetService {

    /** Beans **/
    private final BudgetRepository budgetRepository;
    private final BudgetMemberRepository budgetMemberRepository;
    private final UserService userService;

    /** Mapper **/
    private final BudgetMapper budgetMapper;
    private final UserMapper userMapper;

    public BudgetDTO createBudget(JwtUserDetails jwtUserDetails, BudgetCreateDTO budgetCreateDTO) {

        /*
         * 지금 현재 가계부를 저장하고, 그 멤버를 따로 저장하는 방식을 사용함
         * JPA 스럽지 못한 방법을 사용중에 잇음
         * Budget Entity에 BudgetMember를 세팅해서 넣어주도록 하자.
         */

        // Budget Entity 를 만들어 줘야함.
        Budget budget = budgetMapper.toBudgetFromCreate(budgetCreateDTO);

        budget = budgetRepository.save(budget);

        // budget Member에 자기 자신을 넣어줘야 함.
        UserBaseDTO baseDTO = userService.getUserByUserId(jwtUserDetails.getUsername());
        UserBase base = userMapper.toBaseEntity(baseDTO);
        BudgetMember member = BudgetMember.builder()
                .budget(budget)
                .member(base)
                .role("Owner")
                .build();

        budgetMemberRepository.saveAndFlush(member);

        return budgetMapper.toDTO(budget);
    }

}
