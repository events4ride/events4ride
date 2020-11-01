package com.rides.application.service.user;

import com.rides.application.model.user.User;

import java.util.List;

/**
 * Service interface for class {@link User}.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

public interface UserService {
    List<User> getAll();
    User findById(Long id);
}

