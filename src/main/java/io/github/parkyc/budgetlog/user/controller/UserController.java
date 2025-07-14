package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    /**
     * BudgetLog 사용자에 대한 컨트롤러
     */

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("ok");
    }

}
