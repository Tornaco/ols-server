/*
package com.thoughtworks.nho.ols.server.controllers;

import com.thoughtworks.nho.ols.server.auth.UserAuth;
import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserRepo;
import com.thoughtworks.nho.ols.server.repo.local.MapUserRepo;
import com.thoughtworks.nho.ols.server.repo.UserCenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController(value = "/tor")
public class LoginController {

    private UserCenter userRepo = new MapUserRepo();

    private UserAuth userAuth = new UserAuth();

    @RequestMapping("/hello")
    public String hello() {
        return "Hello" + new Date().toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user) {
        if (user.getId() == null) {
            return new ResponseEntity<>(userAuth.createTokenForUser(user), HttpStatus.BAD_REQUEST);
        }
        if (userRepo.getUserById(user.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (userRepo.getUserById(user.getId()).equals(user)) {
            return new ResponseEntity<>(userAuth.createTokenForUser(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
*/
