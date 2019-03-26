package com.teamapps.milkservice.rest.controller;

import com.teamapps.milkservice.objects.Context;
import com.teamapps.milkservice.rest.dto.UserDto;
import com.teamapps.milkservice.rest.dto.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mihai Alexandru
 * @date 30.01.2019
 */
@RestController
public class UserInfoController {

    private Context context;

    @Autowired
    public UserInfoController(Context context) {
        this.context = context;
    }

    @GetMapping("/users/me")
    UserDto getUserInfo() {
        return UserDtoMapper.toDto(context.getUser());
    }

}
