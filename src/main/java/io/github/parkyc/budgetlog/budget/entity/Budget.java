package io.github.parkyc.budgetlog.budget.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name="budget")
@Entity
@SequenceGenerator(
        name="budget_seq_generator",
        sequenceName="SEQ_BUDGET",
        allocationSize=1
)
@EntityListeners(AuditingEntityListener.class)
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_seq_generator")
    private Long budgetSeq;

    @Column(name="budget_name")
    private String budgetName;

    @Column(name="description", nullable = true)
    private String description;

    @CreatedDate
    @Column(name="create_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<BudgetMember> budgetMembers = new ArrayList<>();
}
