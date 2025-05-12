package io.github.parkyc.budgetlog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {

    private Long id;

    private String userId;

    private String password;

    private String status;

    private String delYn;

}
