package io.github.parkyc.budgetlog.budget.repository;

import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetMemberRepository extends JpaRepository<BudgetMember, Long> {

    List<BudgetMember> findAllByMember(UserBase member);
}
