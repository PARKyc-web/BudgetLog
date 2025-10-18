package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;

public interface BudgetDataService {

    boolean fillInBudget(JwtUserDetails jwtUserDetails, BudgetFillDTO budgetFillDTO);
}
