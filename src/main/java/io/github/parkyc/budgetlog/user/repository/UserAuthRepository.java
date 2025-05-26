package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    Optional<UserAuth> findByEmail(String email);
}
