package io.github.parkyc.budgetlog.budget.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budget_data")
public class BudgetData {
    // 검토완료

    @Id
    @Column(name="data_seq")
    private Long dataSeq;

    @Column(name="budget_seq")
    private Long budgetSeq;

    @Column(name="category_seq")
    private Long categorySeq;

    @Column(name="amount")
    private Long amount;

    @Column(name="quantity")
    private Long quantity;

    @Column(name="type")
    private String type;

    @Column(name="memo")
    private String memo;

    @Column(name="create_id")
    private Long createId;

    @Column(name="update_id")
    private Long updateId;

    @CreatedDate
    @Column(name="create_dt")
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(name="update_dt")
    private LocalDateTime updateDt;











}
