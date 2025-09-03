package io.github.parkyc.budgetlog.budget.repository;

import io.github.parkyc.budgetlog.budget.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
