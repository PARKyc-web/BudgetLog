package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.SignUpDTO;

public interface UserService {

    SignUpDTO createAuthCode(SignUpDTO signUpDTO);


}
