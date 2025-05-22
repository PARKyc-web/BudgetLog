package io.github.parkyc.budgetlog.budget.controller;

import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetContoller {

  private final BudgetService budgetService;

  @GetMapping("/create")
  public BudgetDTO createBudget(){

    return new BudgetDTO().builder().budgetName("test").build();
  }

  @GetMapping("/list")
  public List<BudgetDTO> getMyBudgetList(){

    List<BudgetDTO> budgetList = new ArrayList<>();
    for(int i = 0; i < 10; i++){
      BudgetDTO dto = BudgetDTO.builder().budgetSeq(Long.valueOf(i)).budgetName("Sample Budget "+i).build();

      budgetList.add(dto);
    }
    return budgetList;
  }

}
