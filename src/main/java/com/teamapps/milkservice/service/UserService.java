package com.teamapps.milkservice.service;

import com.teamapps.milkservice.objects.User;

import java.util.Optional;

/**
 * @author Mihai Alexandru
 * @date 25.12.2018
 */
public interface UserService {

    Optional<User> find(String login);

}
