package io.github.parkyc.budgetlog.category.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "budget_category")
public class BudgetCategory {
    // 검토완료

    @Id
    @Column(name = "category_seq")
    private Long categorySeq;

    @Column(name = "budget_seq")
    private Long budgetSeq;

    @Column(name = "category_code")
    private Long categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "image")
    private String image;

    @Column(name = "create_id")
    private Long createId;

    @Column(name = "update_id")
    private Long updateId;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;

}
