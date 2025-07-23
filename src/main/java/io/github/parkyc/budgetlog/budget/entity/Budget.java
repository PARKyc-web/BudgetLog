package io.github.parkyc.budgetlog.budget.entity;

import io.github.parkyc.budgetlog.member.entity.BudgetMember;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name="budget")
public class Budget {

    @Id
    private Long budgetId;

    @Column(name="budget_name")
    private String budgetName;

    @OneToMany
    private BudgetMember budgetMember;
}
