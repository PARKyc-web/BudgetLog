package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.SignUpRequestDTO;
import io.github.parkyc.budgetlog.user.dto.SignUpResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    boolean isAvailableId(@RequestBody SignUpRequestDTO signUpRequestDTO);

    SignUpResponseDTO createAuthCode(SignUpRequestDTO signUpRequestDTO);




}
