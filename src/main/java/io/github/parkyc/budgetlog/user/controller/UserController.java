package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.SignUpRequestDTO;
import io.github.parkyc.budgetlog.user.dto.SignUpResponseDTO;
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
        회원가입 버튼 클릭 >
     */
    @PostMapping("/sign-up")
    public CommonDTO.Response<?> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        
        /* 아이디 중복 확인을 먼저 해야지 */
        boolean isDup = userService.isAvailableId(signUpRequestDTO);
        SignUpResponseDTO response = SignUpResponseDTO.builder()
                .userId(signUpRequestDTO.getUserId())
                .message("Request Id is already in use")
                .build();

        if(isDup){
            response = userService.createAuthCode(signUpRequestDTO);
        }

        return CommonDTO.Response.success(response);
    }

    @PostMapping("/sign-up/confirm")
    public CommonDTO.Response<?> signUpConfirm(@RequestBody SignUpRequestDTO signUpRequestDTO) {


        return CommonDTO.Response.success("ok");
    }

    @GetMapping("/sign-up/duplicate")
    public CommonDTO.Response<?> isDupUserId(String userId) {
        return CommonDTO.Response.success("ok");
    }




}
