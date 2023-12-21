package com.bus.management.busManagement.service;

import com.bus.management.busManagement.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
