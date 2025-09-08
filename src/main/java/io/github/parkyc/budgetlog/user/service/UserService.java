package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;

public interface UserService {

    /**
     * createGuest
     * 게스트 계정 생성 메소드, UUID로 구성된 게스트 계정을 리턴한다.
     * @return
     */
    GuestUserDTO createGuest();

    /**
     * login
     * 아이디, 비밀번호를 받아서 엑세스 토큰 및 리프레쉬 토큰을 발급한다.
     * @param loginDTO
     * @return
     */
    JwtDTO login(LoginDTO loginDTO);

    /**
     * getUserByUserId
     * 사용자 이메일을 받아서 정보를 확인 함.
     * @param userId
     * @return
     */
    UserBaseDTO getUserByUserId(String userId);

}
