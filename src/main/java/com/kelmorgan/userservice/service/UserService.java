package com.kelmorgan.userservice.service;

import com.kelmorgan.userservice.domain.Role;
import com.kelmorgan.userservice.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getAllUsers();
}
