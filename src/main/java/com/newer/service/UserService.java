package com.newer.service;

import com.newer.domain.User;

public interface UserService {

    User login(String username, String password);

    boolean register(User user);

    boolean checkName(String username);

    User findById(int userId);

    int updateUser(int userId, String password);
}
