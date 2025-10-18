package io.github.parkyc.budgetlog.budget.repository;

import io.github.parkyc.budgetlog.budget.entity.BudgetData;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BudgetDataRepository extends JpaRepository<BudgetData, Long> {

    @Query("""
        SELECT bm
          FROM BudgetMember bm
          JOIN bm.member ub
          JOIN bm.budget b
         WHERE ub.userId = :email
           AND b.budgetSeq = :budgetSeq
    """)
    BudgetMember isBudgetMemberByUserId(Long budgetSeq, String email);
}
