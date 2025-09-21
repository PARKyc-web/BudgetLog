package io.github.parkyc.budgetlog.budget.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BudgetMember> budgetMembers = new ArrayList<>();

    public static Budget create(String budgetName, String description) {
        if(budgetName == null || budgetName.isEmpty()){
            throw new IllegalArgumentException("가계부 명은 필수 입력사항입니다.");
        }
        return new Budget(budgetName, description);
    }

    public static Budget from(BudgetCreateDTO createDTO) {
        if(createDTO == null){
            throw new IllegalArgumentException("가계부 생성 DTO의 값은 필수 입력사항입니다.");
        }
        if(createDTO.getBudgetName() == null || createDTO.getBudgetName().isEmpty()){
            throw new IllegalArgumentException("가계부 명은 필수 입력사항입니다.");
        }

        Budget budget = new Budget(createDTO.getBudgetName(), createDTO.getDescription());
        if(createDTO.getBudgetMembers() != null && !createDTO.getBudgetMembers().isEmpty()){
            budget.updateBudgetMember(createDTO.getBudgetMembers());
        }

        return budget;
    }

    private Budget(String budgetName, String description){
        this.budgetName = budgetName;
        this.description = description;
    }

    public void addBudgetMember(BudgetMember budgetMember) {
        budgetMember.updateBudget(this);
        this.budgetMembers.add(budgetMember);
    }
    public void updateBudgetMember(List<BudgetMember> budgetMembers) {
        for(BudgetMember budgetMember : budgetMembers){
            budgetMember.updateBudget(this);
        }
        this.budgetMembers = budgetMembers;
    }
}
