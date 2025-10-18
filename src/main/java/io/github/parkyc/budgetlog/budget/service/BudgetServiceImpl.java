package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.budget.mapper.BudgetMapper;
import io.github.parkyc.budgetlog.budget.repository.BudgetMemberRepository;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import io.github.parkyc.budgetlog.common.enums.BudgetMemberRole;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        // Budget Entity 를 만들어 줘야함.
        Budget budget = Budget.from(budgetCreateDTO);

        /* 가계부 소유자 멤버 생성 및 등록 */
        // codex 추천 : userService에서 현재 DTO를 반환하는게 아니라 userBase를 리턴해서 사용해야한다.
        // 현재는 영속성이 없음
        UserBaseDTO baseDTO = userService.getUserByUserId(jwtUserDetails.getUsername());
        UserBase base = userMapper.toBaseEntity(baseDTO);

        BudgetMember budgetMember = BudgetMember.create(budget, base, BudgetMemberRole.OWNER);
        budget.addBudgetMember(budgetMember);

        budgetRepository.saveAndFlush(budget);

        return budgetMapper.toBudgetDTO(budget);
    }

    public List<BudgetDTO> findAllBudgets(String userId) {

        UserBaseDTO userBaseDTO = userService.getUserByUserId(userId);
        UserBase base = userMapper.toBaseEntity(userBaseDTO);
        List<BudgetMember> budgetMembers = budgetMemberRepository.findAllByMember(base);

        List<BudgetDTO> budgetDTOs = new ArrayList<>();
        for (BudgetMember budgetMember : budgetMembers) {
            BudgetDTO dto = budgetMapper.toBudgetDTO(budgetMember.getBudget());
            budgetDTOs.add(dto);
        }

        return budgetDTOs;
    }

    @Override
    public boolean fillInData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO) {
        return false;
    }

    @Override
    public boolean fillOutData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO) {
        return false;
    }

    @Override
    public boolean modifyFillData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO) {
        return false;
    }
}
