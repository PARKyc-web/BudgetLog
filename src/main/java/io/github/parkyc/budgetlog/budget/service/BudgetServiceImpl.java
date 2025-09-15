package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.budget.mapper.BudgetMapper;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import io.github.parkyc.budgetlog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BudgetServiceImpl implements BudgetService {

    /** Beans **/
    private final BudgetRepository budgetRepository;
    private final UserService userService;

    /** Mapper **/
    private final BudgetMapper budgetMapper;

    public BudgetDTO createBudget(JwtUserDetails jwtUserDetails, BudgetCreateDTO budgetCreateDTO) {

        // Budget Entity 를 만들어 줘야함.
        Budget budget = budgetMapper.toBudgetFromCreate(budgetCreateDTO);

        budget = budgetRepository.saveAndFlush(budget);

        // budget Member에 자기 자신을 넣어줘야 함.
        BudgetMember member = BudgetMember.builder()
                .budget(budget)
                .member(null) // 이 부분에 나의 정보를 넣어줘야 함. userInfo 값을 넣어줘야 함..... userBase 넣는게 좋지 않을까?
                .role("Owner")
                .build();

        return budgetMapper.toDTO(budget);
    }

}
