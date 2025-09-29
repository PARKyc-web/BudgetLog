package io.github.parkyc.budgetlog.budget.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="budget_data")
@Entity
@SequenceGenerator(
        name="budget_data_generator",
        sequenceName="SEQ_BUDGET_DATA",
        allocationSize=1
)
@EntityListeners(AuditingEntityListener.class)
public class BudgetData {

    @Id
    @Column(name="data_seq")
    private Long dataSeq;

    @ManyToOne
    @JoinColumn(name = "budget_seq")
    private Budget budget;

    @ManyToOne
    private BudgetMember budgetMember;

    @Column(name="amount", nullable = false)
    private Long amount;

    @Column(name="count", nullable = false)
    private Long count;

    @Column(name="total", nullable = false)
    private Long total;

    @CreationTimestamp
    @Column(name="create_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="update_date")
    private LocalDateTime updatedDate;

    public static BudgetData create(Budget budget, BudgetMember budgetMember) {
        return new BudgetData();
    }

    private BudgetData(String budgetName, Budget budget, BudgetMember budgetMember) {

    }
}
