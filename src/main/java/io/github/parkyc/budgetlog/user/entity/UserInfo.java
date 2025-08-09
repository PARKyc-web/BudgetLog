package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
@TableGenerator(
        name="USER_INFO_SEQ_GENERATOR",
        table="BUDGET_LOG_SEQUENCE",
        pkColumnName="sequence_name",
        valueColumnName = "next_val",
        pkColumnValue = "USER_INFO_SEQUENCE",
        allocationSize=1 // 한번에 몇개의 Sequence를 증가시킬것인가?, 몇개를 메모리에 가지고 있을것인가?
)
public class UserInfo {

    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "USER_INFO_SEQ_GENERATOR")
    private Long userSeq;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private UserBase userBase;

    // 추가적인 정보 ( 선택적인 정보 )

    @CreationTimestamp
    @Column(name = "created_dt", nullable = false, updatable = false)
    private LocalDateTime createdDt;

    @UpdateTimestamp
    @Column(name="updated_dt", nullable = true)
    private LocalDateTime updatedDt;

    public static UserInfo createFrom(UserBase userBase, String email) {
        UserInfo userInfo = UserInfo.builder()
                .userSeq(userBase.getUserSeq())
                .userBase(userBase)
                .build();
        userBase.setUserInfo(userInfo);
        return userInfo;
    }
}