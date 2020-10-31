package com.rides.application.rest.user;


import com.rides.application.dto.user.UserDto;
import com.rides.application.model.user.User;
import com.rides.application.service.user.RoleService;
import com.rides.application.service.user.UserService;
import com.rides.application.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for {@link User} connected requests.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/users/")
public class UserRestControllerV1 {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRestControllerV1(UserService userService,
                                        RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     *
     * @return
     */

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = this.userService.getAll();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<UserDto> usersDto = ObjectMapperUtils.mapAll(users, UserDto.class);

        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return
     */

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.findById(userId);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserDto usersDto = ObjectMapperUtils.map(user, UserDto.class);

        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }


}
