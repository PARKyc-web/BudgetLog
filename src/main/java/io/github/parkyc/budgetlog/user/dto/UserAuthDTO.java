package io.github.parkyc.budgetlog.user.dto;

import io.github.parkyc.budgetlog.user.entity.UserAuth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {

    private Long seq;

    private String email;

    private String password;

    private String status;

    private String delYn;

}
