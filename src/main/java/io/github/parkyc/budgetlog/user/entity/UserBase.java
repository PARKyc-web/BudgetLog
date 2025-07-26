package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_base")
public class UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name="user_id", nullable = false, unique = true, length = 50)
    private String userId;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="user_name", nullable = false, length = 100)
    private String userName;

    @Column(name="auth_yn", nullable = false, length = 1)
    private String authYn;

    @OneToOne(mappedBy = "userBase", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}