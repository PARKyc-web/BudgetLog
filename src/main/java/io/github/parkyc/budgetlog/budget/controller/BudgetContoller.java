package io.github.parkyc.budgetlog.budget.controller;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.entity.Budget;
import io.github.parkyc.budgetlog.common.response.CommonRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.parkyc.budgetlog.budget.service.BudgetService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetContoller {

  private final BudgetService budgetService;

  @GetMapping("/create")
  public BudgetDTO createBudget(){

    return new BudgetDTO().builder().budgetName("test").build();
  }
}
