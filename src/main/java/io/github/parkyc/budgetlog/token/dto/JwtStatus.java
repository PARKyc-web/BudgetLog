package io.github.parkyc.budgetlog.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JwtStatus {
    VALID(200),
    INVALID(404),
    EXPIRED(401);

    private final int code;
}
