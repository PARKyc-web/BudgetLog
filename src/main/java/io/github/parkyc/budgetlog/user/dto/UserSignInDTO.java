package io.github.parkyc.budgetlog.user.dto;

import io.github.parkyc.budgetlog.user.entity.UserBase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignInDTO {

    @NotBlank(message = "{UserIdNotBlink}")
    @Email(message = "{UserIdEmail}")
    private String userId;

    @NotBlank(message = "{UserPasswordNotBlink}")
    private String password;

    @NotBlank(message = "{UserNameNotBlink}")
    private String userName;

    public UserBase toEntity() {
        return UserBase.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .build();
    }
}