package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.user.service.UserService;
import jakarta.validation.Valid;
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

    @PostMapping("/login")
    public CommonDTO.Response<?> login(@RequestBody @Valid LoginDTO loginDTO){

        return CommonDTO.Response.success("ok");
    }






}
