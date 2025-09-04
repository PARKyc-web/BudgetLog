package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_base")
@Entity
@SequenceGenerator(
        name = "user_seq_generator",
        sequenceName = "SEQ_USER_BASE",
        allocationSize = 5
)
public class UserBase {

    @Id
    @Column(name="user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    private Long userSeq;

    @Column(name="user_id", nullable = false)
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    @OneToOne(mappedBy = "userBase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public void linkUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}