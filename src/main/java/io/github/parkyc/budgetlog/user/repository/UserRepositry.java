package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<UserInfo, Long> {
}
