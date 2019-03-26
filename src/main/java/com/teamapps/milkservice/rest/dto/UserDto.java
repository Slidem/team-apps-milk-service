package com.teamapps.milkservice.rest.dto;

import com.teamapps.milkservice.rest.annotation.Id;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class UserDto {

    @Id
    public Integer id;

    public String login;

    public String firstName;

    public String lastName;

    public String email;

    public String roles;
}
