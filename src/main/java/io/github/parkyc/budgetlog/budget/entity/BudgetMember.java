package io.github.parkyc.budgetlog.budget.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

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
@Table(name = "budget_member")
public class BudgetMember {
    
    @Id
    @Column(name = "member_seq")
    private Long memberSeq;

    @Column(name = "budget_id")
    private Long budgetId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_type")
    private String memberType;

    @CreatedDate
    @Column(name = "join_dt")
    private LocalDateTime joinDt;

    @Column(name = "status")
    private String status;
}
