package io.github.parkyc.budgetlog.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    /**
     * BudgetLog 가계부 참가자에 대한 컨트롤러
     */

    @PostMapping("/join")
    public ResponseEntity<?> joinBudget() {
        return ResponseEntity.ok("Join successful");
    }
}
