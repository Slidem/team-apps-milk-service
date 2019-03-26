package com.teamapps.milkservice.service.impl;

import com.teamapps.milkservice.mapper.UserMapper;
import com.teamapps.milkservice.objects.User;
import com.teamapps.milkservice.repository.UserRepository;
import com.teamapps.milkservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author Mihai Alexandru
 * @date 25.12.2018
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> find(String login) {
        requireNonNull(login);
        return userRepository.getUserEntitiesByLogin(login).map(UserMapper::fromEntity);
    }
}
