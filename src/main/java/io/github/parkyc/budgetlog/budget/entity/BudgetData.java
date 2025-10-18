package io.github.parkyc.budgetlog.budget.entity;

import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(
        name="budget_data",
        indexes = {
                @Index(name="idx_budget_data_total", columnList = "total"),
                @Index(name = "idx_budget_data_amount", columnList = "amount"),
                @Index(name = "idx_budget_data_count", columnList = "count")
        }
)
@Entity
@SequenceGenerator(
        name="budget_data_generator",
        sequenceName="SEQ_BUDGET_DATA",
        allocationSize=1
)
@EntityListeners(AuditingEntityListener.class)
public class BudgetData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_data_generator")
    @Column(name="data_seq")
    private Long dataSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_seq")
    private Budget budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="budget_member", nullable = false)
    private BudgetMember budgetMember;

    @Column(name="amount", nullable = false)
    private Long amount;

    @Column(name="count", nullable = false)
    private Long count;

    @Column(name="total", nullable = false)
    private Long total;

    @CreatedDate
    @Column(name="create_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="update_date")
    private LocalDateTime updateDate;

    public static BudgetData create(Budget budget, BudgetMember budgetMember, Long amount) {
        return new  BudgetData(budget, budgetMember, amount, 1L);
    }

    public static BudgetData create(Budget budget, BudgetMember budgetMember, Long amount, Long count) {
        return new  BudgetData(budget, budgetMember, amount, count);
    }

    private BudgetData(Budget budget, BudgetMember budgetMember, Long amount, Long count) {
        this.budget = budget;
        this.budgetMember = budgetMember;
        this.amount = amount;
        this.count = count;
        this.total = amount * count;
    }

    public static BudgetData from(BudgetFillDTO budgetFillDTO, Budget budget, BudgetMember budgetMember) {
        return create(budget, budgetMember, budgetFillDTO.getAmount(), budgetFillDTO.getCount());
    }

}
