package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.EmailVerifyDTO;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.UserSignInDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.service.UserService;
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
    private final UserService userService;

    @GetMapping("/guest")
    public CommonDTO.Response<?> createGuest(){
        GuestUserDTO guest = userService.createGuest();

        return CommonDTO.Response.success(guest);
    }

    @PostMapping("/sign-up")
    public CommonDTO.Response<?> createUserBase(@Valid @RequestBody UserSignInDTO signInDTO){

        System.out.println(signInDTO);
        // 지금 validation 걸리면 에러가 동일한게 뜸.... 로그인하라고...
        // 이거 수정해야함.
        // 우선 Guest ID를 사용해서 혼자 사용할 수 있도록 하자.
        // 혼자 사용할 때는 게스트 아이디로 충분하지만 다른 가계부에 참가하려면 회원가입을 해야되는거지

        boolean result = userService.sendVerifyEmail(signInDTO);

        return CommonDTO.Response.success(result);
    }

    /**
     * 회원가입 이메일 인증
     * @param emailVerifyDTO
     * @return
     */
    @PostMapping("/verify/email")
    public CommonDTO.Response<?> verifyEmail(EmailVerifyDTO emailVerifyDTO){

        // code만 받으면 되나?
        // 아니지 이메일이랑 코드 두 개를 받아야하지
        //
        return CommonDTO.Response.success("ok");
    }

    @GetMapping("/test")
    public CommonDTO.Response<?> test(){
        return CommonDTO.Response.success("ok");
    }

}
