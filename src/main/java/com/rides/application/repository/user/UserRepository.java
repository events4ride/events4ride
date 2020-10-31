package com.rides.application.repository.user;

import com.rides.application.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link User}.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
