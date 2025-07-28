package io.github.parkyc.budgetlog.user.repository;

import io.github.parkyc.budgetlog.user.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,Long> {

}
