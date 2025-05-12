package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name="user_id", nullable = false, unique = true, length = 512)
    private String userId;

    @Column(name="password", nullable = false, length = 1024)
    private String password;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="del_yn", nullable = false)
    private String delYn;

}
