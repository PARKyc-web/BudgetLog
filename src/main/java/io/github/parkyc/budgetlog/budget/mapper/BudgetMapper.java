package io.github.parkyc.budgetlog.budget.mapper;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    BudgetDTO toBudgetDTO(Budget budget);
}
