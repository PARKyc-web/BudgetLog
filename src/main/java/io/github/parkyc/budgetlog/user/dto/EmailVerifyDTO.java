package io.github.parkyc.budgetlog.user.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class EmailVerifyDTO {
    private String userId;
    private String code;
}
