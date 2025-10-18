package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;

import java.util.List;

public interface BudgetService {

    BudgetDTO createBudget(JwtUserDetails jwtUserDetails, BudgetCreateDTO budgetCreateDTO);

    List<BudgetDTO> findAllBudgets(String userId);

    boolean fillInData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO);

    boolean fillOutData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO);

    boolean modifyFillData(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO);

}
