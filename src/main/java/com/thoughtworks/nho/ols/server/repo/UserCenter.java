package com.thoughtworks.nho.ols.server.repo;

import com.thoughtworks.nho.ols.server.domain.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserCenter {

    private static UserCenter instance = new UserCenter();

    private UserCenter() {
    }

    public static UserCenter getInstance() {
        return instance;
    }

    private final Map<String, User> userMap = new ConcurrentHashMap<>();


    public void addUser(String userName, User user) {
        userMap.put(userName,user);
    }

    public void removeUser(User user) {
        userMap.remove(user.getUsername());
    }

    public User getUserByName(String name) {
        return userMap.get(name);
    }

    public boolean isRegister(User user){
        return userMap.containsKey(user.getUsername());

    }
    public boolean hasUser(User user) {
        User usr = userMap.get(user.getUsername());
        if (null == usr) {
            return false;
        }else if (usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }

}
