package io.github.parkyc.budgetlog.user.dto;

import io.github.parkyc.budgetlog.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userSeq;
    private String userId;
    private String password;
    private String userName;

    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .userSeq(user.getUserSeq())
                .userId(user.getUserId())
                .password(user.getPassword())
                .userName(user.getUserName())
                .build();
    }

}
