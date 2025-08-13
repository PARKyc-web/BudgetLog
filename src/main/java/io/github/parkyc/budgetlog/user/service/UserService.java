package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.EmailVerifyDTO;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.UserSignInDTO;

public interface UserService {

    GuestUserDTO createGuest();

    boolean sendVerifyEmail(UserSignInDTO userSignInDTO);

    boolean verifyEmail(EmailVerifyDTO emailVerifyDTO);




}
