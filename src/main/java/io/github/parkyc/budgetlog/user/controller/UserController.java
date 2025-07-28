package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.SignUpDTO;
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


    /*
        회원가입 버튼 클릭 > 이메일 입력 > 이메일 인증(코드입력) > 비밀번호 및 다른 내용 입력
     */
    @PostMapping("/sign-up")
    public CommonDTO.Response<?> signUp(@RequestBody SignUpDTO signUpDTO) {

        return CommonDTO.Response.success("ok");
    }

    @PostMapping("/sign-up/confirm")
    public CommonDTO.Response<?> signUpConfirm(@RequestBody SignUpDTO signUpDTO) {

        // 인증 회원의 Code 값을 받는다.
        //

        return CommonDTO.Response.success("ok");
    }

    @GetMapping("/sign-up/duplicate")
    public CommonDTO.Response<?> isDupUserId(String userId) {
        return CommonDTO.Response.success("ok");
    }




}
