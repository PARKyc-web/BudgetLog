package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name="user_seq")
    private Long userSeq;

}
