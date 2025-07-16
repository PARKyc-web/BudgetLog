package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "budget_user")
public class User {

    @Id
    private Long userSeq;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String userName;

    /* 일단 심플하게, 로그인정도까지만 할 수 있도록 설정 */
}
