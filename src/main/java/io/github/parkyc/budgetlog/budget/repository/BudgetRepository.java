package io.github.parkyc.budgetlog.budget.repository;

import io.github.parkyc.budgetlog.budget.entity.Budget;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    public List<Budget> findByBudgetName(String budgetName);
} 