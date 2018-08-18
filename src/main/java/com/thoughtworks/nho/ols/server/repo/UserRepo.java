package com.thoughtworks.nho.ols.server.repo;

import com.thoughtworks.nho.ols.server.domain.User;

public interface UserRepo {
    void addUser(User user);

    void removeUser(User user);

    void updateUser(User user);

    User getUserById(String id);
}
