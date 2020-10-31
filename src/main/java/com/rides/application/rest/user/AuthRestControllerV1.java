package com.rides.application.rest.user;

import com.rides.application.dto.user.SignUpUserDto;
import com.rides.application.service.user.RoleService;
import com.rides.application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for User {@link User} authorization requests.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthRestControllerV1 {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AuthRestControllerV1(UserService userService,
                                RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }
}
