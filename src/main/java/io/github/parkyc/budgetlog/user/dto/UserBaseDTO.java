package io.github.parkyc.budgetlog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBaseDTO {

    private Long userSeq;

    private String userId;

    private String password;

    private String role;
}
