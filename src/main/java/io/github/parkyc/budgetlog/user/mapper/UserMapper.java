package io.github.parkyc.budgetlog.user.mapper;

import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /** Guest User Method **/
    GuestUserDTO toGuestUserDTO(UserBase userBase);

    /** User Base Method **/
    UserBase toBaseEntity(UserBaseDTO userBaseDTO);

    UserBaseDTO toUserBaseDTO(UserBase userBase);

}
