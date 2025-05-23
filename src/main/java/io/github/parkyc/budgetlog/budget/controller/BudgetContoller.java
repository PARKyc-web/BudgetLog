package io.github.parkyc.budgetlog.budget.controller;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BudgetContoller {

    private final BudgetService budgetService;

    @GetMapping("/budget")
    public List<BudgetDTO> getMyBudgetList(){

        System.out.println("## Run getMyBudgetList");
        List<BudgetDTO> budgetList = budgetService.findAll();

        return budgetList;
    }

    @PostMapping("/budget")
    public BudgetDTO createBudget(@RequestBody BudgetDTO budgetDTO){

        return budgetService.createBudget(budgetDTO);
    }

    @PutMapping("/budget")
    public BudgetDTO updateBudget(@RequestBody BudgetDTO budgetDTO){

        return budgetDTO;
    }

}
