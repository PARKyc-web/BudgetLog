package io.github.parkyc.budgetlog.budget.entity;

import io.github.parkyc.budgetlog.common.enums.BudgetMemberRole;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="budget_member")
@Entity
@SequenceGenerator(
        name="budget_member_generator",
        sequenceName = "SEQ_BUDGET_MEMBER",
        allocationSize = 1
)
@EntityListeners(AuditingEntityListener.class)
public class BudgetMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long BudgetMemberSeq;

    @ManyToOne
    @JoinColumn(name="budget_seq", nullable = false)
    private Budget budget;

    @ManyToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private UserBase member;

    // 멤버권한 (Owner, Member, Viewer)
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private BudgetMemberRole role;

    @CreatedDate
    @Column(name="create_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="update_date")
    private LocalDateTime updatedDate;

    public static BudgetMember create(Budget budget, UserBase member, BudgetMemberRole role){
        if(budget == null){
            throw new IllegalArgumentException("가계부 정보는 필수 입력사항입니다.");
        }
        if(member == null){
            throw new IllegalArgumentException("가계부 멤버는 필수 입력사항입니다.");
        }
        if(role == null){
            throw new IllegalArgumentException("가계부 멤버의 권한은 필수 입력사항입니다.");
        }

        return new BudgetMember(budget, member, role);
    }
    private BudgetMember(Budget budget, UserBase member, BudgetMemberRole role) {
        this.budget = budget;
        this.member = member;
        this.role = role;
    }
    public void updateBudget(Budget budget){
        this.budget = budget;
    }
    public void updateRole(BudgetMemberRole role){
        this.role = role;
    }
}
