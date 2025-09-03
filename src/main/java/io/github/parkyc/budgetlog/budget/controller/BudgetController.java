package io.github.parkyc.budgetlog.budget.controller;


import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.common.CommonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    public CommonDTO.Response<?> getBudgetList(){
        return CommonDTO.Response.ok("");
    }

    public CommonDTO.Response<?> createBudget(){

        return CommonDTO.Response.ok("");
    }


}
