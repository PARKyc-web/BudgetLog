package io.github.parkyc.budgetlog.budget.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "budget")
public class Budget {
    
    @Id
    @Column(name = "budget_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetSeq;

    @Column(name = "budget_name", length = 255)
    private String budgetName;

    @Column(name = "description", columnDefinition = "CLOB")
    private String description;

    @Column(name = "owner")
    private String owner;

    @CreatedDate
    @Column(name = "create_dt")
    private LocalDateTime createDt;
    
    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    @Column(name = "is_public")
    private String isPublic;
    
}
