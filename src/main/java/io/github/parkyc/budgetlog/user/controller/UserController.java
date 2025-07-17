package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.entity.User;
import io.github.parkyc.budgetlog.user.repository.UserRepositry;
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
       H2 DB를 사용할 때, 계정을 생성하기 위함.
    */
    @GetMapping("/temp")
    public CommonDTO.Response<UserDTO> makeTempUser() {
        UserDTO user = userService.makeTempUser();

        return CommonDTO.Response.success(user);
    }
    @PostMapping("/create")
    public CommonDTO.Response<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO result = userService.createUser(user);

        return CommonDTO.Response.success(result);
    }


}
