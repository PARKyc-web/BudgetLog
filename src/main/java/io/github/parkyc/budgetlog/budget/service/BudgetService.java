package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BudgetService {

    List<BudgetDTO> findAll();

    List<BudgetDTO> findByBudgetName(String budgetName);

    BudgetDTO createBudget(BudgetDTO budgetDTO);
} 