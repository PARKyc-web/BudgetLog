package io.github.parkyc.budgetlog.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetSearchDTO {
    
    private String budgetId;

    private String budgetName;

    private String owner;

    private String budgetType;
    
}
