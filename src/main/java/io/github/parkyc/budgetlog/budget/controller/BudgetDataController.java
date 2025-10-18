package io.github.parkyc.budgetlog.budget.controller;

import io.github.parkyc.budgetlog.budget.dto.BudgetFillDTO;
import io.github.parkyc.budgetlog.budget.service.BudgetDataService;
import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.config.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/budget/data")
@RestController
public class BudgetDataController {

    /* 가계부 데이터 관련 Controller */

    private final BudgetDataService budgetDataService;

    @PostMapping("/fill-in")
    public CommonDTO.Response<?> fillBudget(@AuthenticationPrincipal JwtUserDetails jwtUserDetails
            , @RequestBody BudgetFillDTO budgetFillDTO) {

        // 현재 가계부 번호 + 회원 아이디
        budgetDataService.fillInBudget(jwtUserDetails, budgetFillDTO);


        return CommonDTO.Response.ok("ok");
    }

    @PostMapping("/fill-out")
    public CommonDTO.Response<?> fillOutBudget(@AuthenticationPrincipal JwtUserDetails jwtUserDetails
            , BudgetFillDTO budgetFillDTO){

        return CommonDTO.Response.ok("ok");
    }

    @PostMapping("/modify")
    public CommonDTO.Response<?> modifyFillData(@AuthenticationPrincipal JwtUserDetails jwtUserDetails
            , BudgetFillDTO budgetFillDTO){
        return CommonDTO.Response.ok("ok");
    }
}
