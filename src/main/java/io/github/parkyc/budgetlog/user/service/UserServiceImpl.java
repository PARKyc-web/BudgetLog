package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.entity.User;
import io.github.parkyc.budgetlog.user.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositry userRepositry;


    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = UserDTO.toEntity(userDTO);
        userRepositry.saveAndFlush(user);

        return UserDTO.toDTO(user);
    }

    @Override
    public UserDTO makeTempUser() {
        User user = User.builder()
                .userId("user")
                .password("user!@34")
                .userName("temp user")
                .build();

        return UserDTO.toDTO(user);
    }


}
