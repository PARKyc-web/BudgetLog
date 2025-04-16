package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public List<Budget> findByBudgetName(String budgetName) {
        return budgetRepository.findByBudgetName(budgetName);
    }
} 