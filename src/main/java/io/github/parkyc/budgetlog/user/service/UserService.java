package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.user.dto.UserAuthDTO;

public interface UserService {

    LoginDTO signUp(LoginDTO loginDTO);
}
