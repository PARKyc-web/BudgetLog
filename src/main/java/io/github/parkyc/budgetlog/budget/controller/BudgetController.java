package io.github.parkyc.budgetlog.budget.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    public String test() {
        return "BudgetLog 가계부 컨트롤러";
    }

    public ResponseEntity<?> test2(){
        return ResponseEntity.ok("BudgetLog 가계부 컨트롤러 테스트");
    }

}
