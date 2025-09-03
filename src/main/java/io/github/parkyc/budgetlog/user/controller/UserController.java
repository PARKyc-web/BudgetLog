package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.user.service.UserService;
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

        return CommonDTO.Response.ok(guest);
    }

    @PostMapping("/login")
    public CommonDTO.Response<?> login(@RequestBody LoginDTO loginDTO){
        JwtDTO token = userService.login(loginDTO);
        return CommonDTO.Response.ok(token);
    }

}
