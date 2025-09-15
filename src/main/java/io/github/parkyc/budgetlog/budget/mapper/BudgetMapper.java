package io.github.parkyc.budgetlog.budget.mapper;

import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    BudgetDTO toDTO(Budget budget);
    Budget toEntity(BudgetDTO budgetDTO);

    Budget toBudgetFromCreate(BudgetCreateDTO budgetCreateDTO);



}
