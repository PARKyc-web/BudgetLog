package io.github.parkyc.budgetlog.user.mapper;

import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    GuestUserDTO toGuestUserDTO(UserBase userBase);

    UserBaseDTO toUserBaseDTO(UserBase userBase);

}
