package io.github.parkyc.budgetlog.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {

  private Long budgetSeq;

  private String budgetName;

  private String description;

  private Long owner;

  private String createDt;

  private String updateDt;
}
