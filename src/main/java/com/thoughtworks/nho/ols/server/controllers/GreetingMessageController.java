package com.thoughtworks.nho.ols.server.controllers;

import com.thoughtworks.nho.ols.server.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/greeting")
public class GreetingMessageController {

    @Autowired
    private MessageService service;

    @GetMapping
    public String getGreetingMessage() {
        return service.getGreetingMessage();
    }
}
