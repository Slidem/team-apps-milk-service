package com.teamapps.milkservice.rest.config;

import com.teamapps.milkservice.exception.NotFoundException;
import com.teamapps.milkservice.objects.Context;
import com.teamapps.milkservice.objects.User;
import com.teamapps.milkservice.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Mihai Alexandru
 * @date 25.12.2018
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestContext implements Context {

    private User user;

    public RequestContext(UserService userService) {
        this.user = findUserFromAuthContext(userService);
    }

    @Override
    public User getUser() {
        return this.user;
    }

    private User findUserFromAuthContext(UserService userService) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = (String) principal;
        return userService.find(login).orElseThrow(() -> new NotFoundException("No user found for login " + login));
    }
}
