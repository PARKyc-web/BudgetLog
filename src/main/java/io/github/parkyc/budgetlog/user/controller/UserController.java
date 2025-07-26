package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    /**
     * BudgetLog 사용자에 대한 컨트롤러
     */
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("ok");
    }


    @GetMapping("/dd")
    public CommonDTO.Response<?> test(){
        return CommonDTO.Response.success("ok");
    }




}
