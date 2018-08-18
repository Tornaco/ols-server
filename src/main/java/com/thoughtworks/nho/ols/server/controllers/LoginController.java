package com.thoughtworks.nho.ols.server.controllers;

import com.thoughtworks.nho.ols.server.auth.UserAuth;
import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserRepo;
import com.thoughtworks.nho.ols.server.repo.local.MapUserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController(value = "/tor")
public class LoginController {

    private UserRepo userRepo = new MapUserRepo();

    private UserAuth userAuth = new UserAuth();

    @RequestMapping("/hello")
    public String hello() {
        return "Hello" + new Date().toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam User user) {
        if (user.getId() == null) return null;
        boolean exist = userRepo.getUserById(user.getId()) != null;
        if (!exist) return null;
        boolean match = userRepo.getUserById(user.getId())
                .equals(user);
        if (match) {
            return userAuth.createTokenForUser(user);
        }
        return null;
    }
}
