package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<User, Long> {
}
