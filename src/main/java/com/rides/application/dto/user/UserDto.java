package com.rides.application.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rides.application.model.user.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * DTO class for user responses by USER
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
    String phone;
    List<RoleDto> roles;
    UserStatus userStatus;
}
