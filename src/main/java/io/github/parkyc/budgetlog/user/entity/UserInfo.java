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
public class UserInfo {

    @Id
    @Column(name = "user_seq")
    private Long userSeq;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private UserBase userBase;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
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
                .email(email)
                .build();
        userBase.setUserInfo(userInfo);
        return userInfo;
    }
}