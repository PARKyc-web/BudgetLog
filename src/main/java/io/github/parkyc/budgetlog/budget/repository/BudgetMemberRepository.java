package io.github.parkyc.budgetlog.budget.repository;

import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetMemberRepository extends JpaRepository<BudgetMember, Long> {
}
