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
    @Column(name = "budget_member_seq")
    private Long budgetMemberSeq;

    @Column(name = "budget_seq")
    private Long budgetSeq;

    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name = "budget_role")
    private String budgetRole;

    @Column(name = "joined_dt")
    private LocalDateTime joinedDt;

    @Column(name = "status")
    private String status;
}
