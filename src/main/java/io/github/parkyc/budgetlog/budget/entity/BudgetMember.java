package io.github.parkyc.budgetlog.budget.entity;

import io.github.parkyc.budgetlog.user.entity.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name="budget_member")
@Entity
@SequenceGenerator(
        name="budget_member_generator",
        sequenceName = "SEQ_BUDGET_MEMBER",
        allocationSize = 1
)
public class BudgetMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long BudgetMemberSeq;

    @ManyToOne
    @JoinColumn(name="budget_seq", nullable = false)
    private Budget budget;

    @ManyToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private UserInfo member;

    // 멤버권한 (Owner, Member, Viewer)
    @Column(name = "role", nullable = false)
    private String role;
}
