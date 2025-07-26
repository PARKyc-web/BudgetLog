package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import io.github.parkyc.budgetlog.user.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositry userRepositry;

}
