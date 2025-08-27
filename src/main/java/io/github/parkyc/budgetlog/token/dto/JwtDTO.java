package io.github.parkyc.budgetlog.token.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtDTO {

    private boolean valid;
    private String accessToken;
    private String refreshToken;
}
