package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_info")
public class UserInfo {
    // 검토완료

    @Id
    @Column(name="user_seq")
    private Long userSeq;

    @Column(name="nickname", nullable = false, length = 1024)
    private String nickname;

    @Column(name="telno", nullable = false, length = 32)
    private String telno;

    /* 추후 컬럼 추가 */

    @Column(name="update_dt")
    private LocalDateTime updateDt;

    /* 테이블 관계 */
    @OneToOne
    @MapsId
    @JoinColumn(name="user_seq")
    private UserAuth userAuth;
}
