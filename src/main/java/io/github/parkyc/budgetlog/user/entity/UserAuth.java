package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_auth")
public class UserAuth {

    @Id
    private String userId;

    private String code;

    private LocalDateTime expireTime;
}
