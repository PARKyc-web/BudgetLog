package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
