package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.budget.repository.BudgetDataRepository;
import io.github.parkyc.budgetlog.budget.repository.BudgetMemberRepository;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BudgetDataServiceImpl implements BudgetDataService {

    private final BudgetDataRepository budgetDataRepository;

    private final BudgetMemberRepository budgetMemberRepository;

    @Override
    public boolean fillInBudget(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO) {

        // jwtUserDetail의 id를 기반으로 사용자의 id를 조회한다.
        // userId를 기반으로 가계부 멤버를 조회해서 데이터를 가져옴
        BudgetMember bm = budgetDataRepository.isBudgetMemberByUserId(5L, jwtUserDetails.getUsername());
        System.out.println(bm);

        //DSL Version
        boolean result = budgetMemberRepository.existsBudgetMemberByUserId(5L, jwtUserDetails.getUsername());
        System.out.println(result);

        // 유저가 가계부에 등록할 권한이 있는지?

        // 권한이 없으면 return false

        // Data insert

        return false;
    }
}
