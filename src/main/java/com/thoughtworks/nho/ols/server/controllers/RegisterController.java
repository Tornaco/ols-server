package com.thoughtworks.nho.ols.server.controllers;

import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserCenter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author hpliu on 2018/8/18.
 */

@RestController(value = "/api")
public class RegisterController {
    private UserCenter uc = UserCenter.getInstance();

    @RequestMapping(value = "/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        if (Strings.isEmpty(username) || Strings.isEmpty(password)) {
            return new ResponseEntity<>("username or password is empty.", HttpStatus.BAD_REQUEST);
        } else if (uc.isRegister(user)) {
            return new ResponseEntity<>("user already registered.", HttpStatus.BAD_REQUEST);
        } else if (password.length() < 6) {
            return new ResponseEntity<>("password must be greater than 6.", HttpStatus.BAD_REQUEST);
        } else {
            String userId = UUID.randomUUID().toString();
            User usr = new User(username, password, userId);
            uc.addUser(username, usr);
            return new ResponseEntity<>("register success,please login.", HttpStatus.OK);
        }

    }
    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user) {
        if (user.getId() == null) {
            return new ResponseEntity<>(createTokenForUser(user), HttpStatus.BAD_REQUEST);
        }
        if (uc.getUserById(user.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (uc.hasUser(user) {
            return new ResponseEntity<>(createTokenForUser(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public String createTokenForUser(User user) {
        return user.getId() == null ? null : String.valueOf(user.getId().hashCode());
    }*/

}

