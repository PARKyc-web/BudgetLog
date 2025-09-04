package io.github.parkyc.budgetlog.budget.controller;


import io.github.parkyc.budgetlog.budget.dto.BudgetDTO;
import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    @GetMapping("/list")
    public CommonDTO.Response<?> getBudgetList(@AuthenticationPrincipal JwtUserDetails jwtUserDetails) {
        return CommonDTO.Response.ok("");
    }

    @PostMapping("/create")
    public CommonDTO.Response<?> createBudget(){

        return CommonDTO.Response.ok("");
    }

}
