package com.thoughtworks.nho.ols.server.repo.local;

import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class MapUserRepo implements UserRepo {

    private final Map<String, User> storage = new HashMap<>();

    @Override
    public void addUser(User user) {
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
        } else {
            
        }
    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserById(String id) {
        return null;
    }
}
