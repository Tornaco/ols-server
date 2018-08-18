package com.thoughtworks.nho.ols.server.domain;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;

    private String id;
}
