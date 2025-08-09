package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_auth")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableGenerator(
        name="USER_AUTH_SEQ_GENERATOR",
        table="BUDGET_LOG_SEQUENCE",
        pkColumnName="sequence_name",
        valueColumnName = "next_val",
        pkColumnValue = "USER_AUTH_SEQUENCE",
        allocationSize=1 // 한번에 몇개의 Sequence를 증가시킬것인가?, 몇개를 메모리에 가지고 있을것인가?
)
public class UserAuth {

    @Id
    @Column(name="auth_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "USER_AUTH_SEQ_GENERATOR")
    private Long authSeq;

    @Column(name="user_id", nullable=false)
    private String userId;

    @Column(name="code", nullable=false)
    private String code;

    @Column(name="expire_time")
    private LocalDateTime expireTime;
}
