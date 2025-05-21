package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="user_auth")
public class UserAuth {
    // 검토완료

    @Id
    @Column(name="user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="del_yn", nullable = false)
    private String delYn;

    @CreatedDate
    @Column(name="create_dt")
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(name="update_dt")
    private LocalDateTime updateDt;

}
