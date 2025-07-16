package io.github.parkyc.budgetlog.user.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.entity.User;
import io.github.parkyc.budgetlog.user.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    /**
     * BudgetLog 사용자에 대한 컨트롤러
     */
    private final UserRepositry userRepositry;

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/temp")
    public CommonDTO.Response<UserDTO> makeTempUser() {
        User user = User.builder()
                .userId("user")
                .password("user!@34")
                .userName("temp user")
                .build();
        UserDTO dto = UserDTO.toDTO(user);

        return CommonDTO.Response.success(dto);
    }

}
