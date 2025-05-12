package io.github.parkyc.budgetlog.budget.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.parkyc.budgetlog.budget.dto.BudgetSearchDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.budget.service.BudgetService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetContoller {
    
    private final BudgetService budgetService;

    @GetMapping("/search")
    public ResponseEntity<List<Budget>> getBudgets() {
        
        return ResponseEntity.ok(budgetService.findAll());
    }

    @GetMapping("/search/list")
    public ResponseEntity<List<Budget>> getBudgets(BudgetSearchDTO budgetSearchDTO) {
        return ResponseEntity.ok(budgetService.findByBudgetName(budgetSearchDTO.getBudgetName()));
    }
}
