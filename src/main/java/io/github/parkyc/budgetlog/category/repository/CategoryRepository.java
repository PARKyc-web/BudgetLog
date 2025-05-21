package io.github.parkyc.budgetlog.category.repository;

import io.github.parkyc.budgetlog.category.entity.BudgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<BudgetCategory, Long> {

}
