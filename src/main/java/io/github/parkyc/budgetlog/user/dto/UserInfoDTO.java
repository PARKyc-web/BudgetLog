package io.github.parkyc.budgetlog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private String userSeq;

    private String userName;

    private String email;

    private String tel;

    private String address;

    private String addressDetail;

}
