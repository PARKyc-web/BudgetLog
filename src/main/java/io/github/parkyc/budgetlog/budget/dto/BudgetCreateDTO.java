package io.github.parkyc.budgetlog.budget.dto;

import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetCreateDTO {

    private String budgetName;

    private String description;

    private String userId;
}
