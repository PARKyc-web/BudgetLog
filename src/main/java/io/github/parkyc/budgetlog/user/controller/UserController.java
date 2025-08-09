package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.UserSignInDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    /**
     * BudgetLog 사용자에 대한 컨트롤러
     */

    @PostMapping("/create")
    public CommonDTO.Response<?> createUserBase(@Valid @RequestBody UserSignInDTO signInDTO){

        System.out.println(signInDTO);

        // userBase 생성
        // 이메일 인증
        // userInfo 생성


        return CommonDTO.Response.success("ok");
    }

    @GetMapping("/test")
    public CommonDTO.Response<?> test(){
        return CommonDTO.Response.success("ok");
    }

}
