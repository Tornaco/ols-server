package com.thoughtworks.nho.ols.server.repo.local;

import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class MapUserRepo implements UserRepo {

    private final Map<String, User> storage = new HashMap<>();

    public MapUserRepo() {
        addUser(new User("Admin", "Admin@tw", "0"));
    }

    @Override
    public void addUser(User user) {
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
        }
    }

    @Override
    public void removeUser(User user) {
        storage.remove(user.getId());
    }

    @Override
    public void updateUser(User user) {
        storage.put(user.getId(), user);
    }

    @Override
    public User getUserById(String id) {
        return storage.get(id);
    }
}
