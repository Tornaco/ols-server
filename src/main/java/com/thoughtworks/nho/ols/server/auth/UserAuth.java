package com.thoughtworks.nho.ols.server.auth;

import com.thoughtworks.nho.ols.server.domain.User;

public class UserAuth {

    public String createTokenForUser(User user) {
        return user.getId() == null ? null : String.valueOf(user.getUsername());
    }
}
