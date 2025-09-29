package io.github.parkyc.budgetlog.budget.controller;


import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.service.BudgetService;
import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/list")
    public CommonDTO.Response<?> getBudgetList(@AuthenticationPrincipal JwtUserDetails jwtUserDetails) {

        List<BudgetDTO> budgetList = budgetService.findAllBudgets(jwtUserDetails.getUsername());

        return CommonDTO.Response.ok(budgetList);
    }

    @PostMapping("/create")
    public CommonDTO.Response<?> createBudget(@AuthenticationPrincipal JwtUserDetails jwtUserDetails
            , @RequestBody BudgetCreateDTO budgetCreateDTO) {

        BudgetDTO budget = budgetService.createBudget(jwtUserDetails, budgetCreateDTO);

        return CommonDTO.Response.ok(budget);
    }

    @PostMapping("/fill-in")
    public CommonDTO.Response<?> fillBudget(@AuthenticationPrincipal JwtUserDetails jwtUserDetails){

        return CommonDTO.Response.ok("ok");
    }

}
