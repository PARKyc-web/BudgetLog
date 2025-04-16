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
    
    @Id
    @Column(name = "data_seq")
    private Long dataSeq;

    @Column(name = "budget_id")
    private Long budgetId;
    
    @Column(name = "amount")   
    private Long amount;

    @Column(name = "quantity")
    private Long quantity;
    
    @Column(name = "total")
    private Long total;

    @Column(name = "memo")
    private String memo;

    @Column(name = "regist_id")
    private String registId;

    @Column(name = "update_id")
    private String updateId;

    @CreatedDate
    @Column(name = "create_dt")
    private LocalDateTime createDt;
    
    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt; 

}
