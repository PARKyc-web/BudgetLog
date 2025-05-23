package io.github.parkyc.budgetlog.budget.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "budget")
public class Budget {
    // 검토완료

    @Id
    @Column(name="budget_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetSeq;

    @Column(name="budget_name")
    private String budgetName;

    @Column(name="description")
    private String description;

    @Column(name="owner") // user_seq
    private Long owner;

    @CreatedDate
    @Column(name="create_dt")
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(name="update_dt")
    private LocalDateTime updateDt;

    
}
