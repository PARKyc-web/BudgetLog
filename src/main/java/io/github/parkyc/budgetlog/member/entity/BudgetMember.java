package io.github.parkyc.budgetlog.member.entity;

import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name="budget_member")
public class BudgetMember {

    @ManyToOne
    private Budget budget;

    @OneToMany
    private UserInfo member;

    // 멤버권한 (Owner, Member, Viewer)
    @Column(name = "role", nullable = false)
    private String role;
}
