package io.github.parkyc.budgetlog.budget.dto;

import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {

    private Long budgetSeq;
    private String budgetName;
    private List<BudgetMember>  budgetMembers;
}
