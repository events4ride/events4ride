package com.rides.application.repository.user;

import com.rides.application.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Role}.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
}
