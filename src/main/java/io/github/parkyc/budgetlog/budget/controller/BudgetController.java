package io.github.parkyc.budgetlog.budget.controller;


import io.github.parkyc.budgetlog.budget.dto.BudgetCreateDTO;
import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.budget.service.BudgetService;
import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/list")
    public CommonDTO.Response<?> getBudgetList(@AuthenticationPrincipal JwtUserDetails jwtUserDetails) {



        return null;
    }

    @PostMapping("/create")
    public CommonDTO.Response<?> createBudget(@AuthenticationPrincipal JwtUserDetails jwtUserDetails
            , BudgetCreateDTO budgetCreateDTO) {

        budgetCreateDTO.setUserId(jwtUserDetails.getUsername());
        BudgetDTO budget = budgetService.createBudget(jwtUserDetails, budgetCreateDTO);

        return CommonDTO.Response.ok(budget);
    }

}
