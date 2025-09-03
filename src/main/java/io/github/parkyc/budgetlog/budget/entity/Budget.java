package io.github.parkyc.budgetlog.budget.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Table(name="budget")
@Entity
@SequenceGenerator(
        name="budget_seq_generator",
        sequenceName="SEQ_BUDGET",
        allocationSize=1
)
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_seq_generator")
    private Long budgetSeq;

    @Column(name="budget_name")
    private String budgetName;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<BudgetMember> budgetMembers = new ArrayList<>();
}
