package io.github.parkyc.budgetlog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {

    /* 이메일을 아이디로 사용함.
     * ex) naver-test@naver.com
     */
    private String userId;

    private String password;

    private String userName;
    
    // signUp/confirm 에서 사용할 코드 > 이메일 인증코드
    private String code;
}
