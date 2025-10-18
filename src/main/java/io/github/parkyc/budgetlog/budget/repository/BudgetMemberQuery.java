package io.github.parkyc.budgetlog.budget.repository;

public interface BudgetMemberQuery {
    boolean existsBudgetMemberByUserId(Long budgetSeq, String userId);
}
