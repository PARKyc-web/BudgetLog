package io.github.parkyc.budgetlog.budget.service;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    public List<BudgetDTO> findAll() {
        List<Budget> budgetList = budgetRepository.findAll();
        List<BudgetDTO> result = new ArrayList<>();
        for(Budget budget : budgetList){
            BudgetDTO dto = BudgetDTO.entityToDTO(budget);
            result.add(dto);
        }

        return result;
    }

    public List<BudgetDTO> findByBudgetName(String budgetName) {
        List<Budget> budgetList = budgetRepository.findByBudgetName(budgetName);
        List<BudgetDTO> result = new ArrayList<>();
        for(Budget budget : budgetList){
            BudgetDTO dto = BudgetDTO.entityToDTO(budget);
            result.add(dto);
        }

        return result;
    }

    public BudgetDTO createBudget(BudgetDTO budgetDTO){
        Budget budget = new Budget();
        budget.setBudgetName(budgetDTO.getBudgetName());
        budget.setDescription(budgetDTO.getDescription());
        budget.setOwner(budgetDTO.getOwner());

        Budget result = budgetRepository.save(budget);

        return BudgetDTO.entityToDTO(result);
    }

}
