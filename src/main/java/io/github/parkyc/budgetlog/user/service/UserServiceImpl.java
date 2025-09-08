package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.token.service.JwtService;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.repository.UserBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /** Beans **/
    private final UserBaseRepository userBaseRepository;
    private final JwtService jwtService;

    /** Mapper **/
    private final UserMapper userMapper;


    /** Method **/
    @Override
    public GuestUserDTO createGuest() {

        String uuid = UUID.randomUUID().toString();
        UserBase guest = UserBase.builder()
                .userId(uuid)
                .password(uuid)
                .role("ROLE_GUEST")
                .build();

        UserInfo info = UserInfo.builder()
                .userName("게스트계정")
                .userBase(guest)
                .build();
        guest.linkUserInfo(info);

        userBaseRepository.saveAndFlush(guest);

        return userMapper.toGuestUserDTO(guest);
    }

    @Override
    public JwtDTO login(LoginDTO loginDTO) {

        UserBase base = userBaseRepository.findByUserId(loginDTO.getUserId());
        if(base == null){
            return null;
        }

        String encPassword = loginDTO.getPassword(); // 여기서 사용자가 입력한 비밀번호의 인코딩을 진행 함.
        if(!encPassword.equals(base.getPassword())){
            return null;
        }

        UserBaseDTO dto = userMapper.toUserBaseDTO(base);

        return jwtService.createToken(dto);
    }

    @Override
    public UserBaseDTO getUserByUserId(String userId) {

        UserBase base = userBaseRepository.findByUserId(userId);
        if(base == null){
            return null;
        }

        return userMapper.toUserBaseDTO(base); // UserSeq 및 password 포함
    }
}
