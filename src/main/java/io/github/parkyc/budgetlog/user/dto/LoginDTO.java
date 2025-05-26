package io.github.parkyc.budgetlog.user.dto;

import io.github.parkyc.budgetlog.user.entity.UserAuth;
import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;

    public LoginDTO(UserAuth userAuth) {
        this.email = userAuth.getEmail();
        this.password = userAuth.getPassword();
    }
}
