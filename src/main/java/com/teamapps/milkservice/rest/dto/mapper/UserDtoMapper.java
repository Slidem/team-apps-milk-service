package com.teamapps.milkservice.rest.dto.mapper;

import com.teamapps.milkservice.objects.User;
import com.teamapps.milkservice.rest.dto.UserDto;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class UserDtoMapper {

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.login = user.getLogin();
        userDto.email = user.getEmail();
        userDto.firstName = user.getFirstName();
        userDto.lastName = user.getLastName();
        return userDto;
    }
}
