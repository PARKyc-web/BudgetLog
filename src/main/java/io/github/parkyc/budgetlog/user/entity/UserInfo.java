package io.github.parkyc.budgetlog.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
@Entity
@SequenceGenerator(
        name = "user_info_generator",
        sequenceName = "SEQ_USER_INFO",
        allocationSize = 5
)
public class UserInfo {

    @Id
    @Column(name="user_info_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userInfoSeq;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "tel")
    private String tel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", referencedColumnName = "user_seq")
    private UserBase userBase;

}