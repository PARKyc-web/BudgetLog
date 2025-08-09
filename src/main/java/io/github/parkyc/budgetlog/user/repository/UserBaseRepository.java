package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBaseRepository extends JpaRepository<UserBase, Long> {
}
