package io.github.parkyc.budgetlog.budget.dto;

import io.github.parkyc.budgetlog.budget.entity.Budget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {

  private Long budgetSeq;

  private String budgetName;

  private String description;

  private Long owner;

  private LocalDateTime createDt;

  private LocalDateTime updateDt;

  public static BudgetDTO entityToDTO(Budget budget){
    BudgetDTO dto = new BudgetDTO();

    dto.setBudgetSeq(budget.getBudgetSeq());
    dto.setOwner(budget.getOwner());
    dto.setDescription(budget.getDescription());
    dto.setBudgetName(budget.getBudgetName());

    return dto;
  }
}
