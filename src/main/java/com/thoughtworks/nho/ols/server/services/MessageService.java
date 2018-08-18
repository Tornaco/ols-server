package com.thoughtworks.nho.ols.server.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
   public String getGreetingMessage() {
       return "欢迎加入TW!!";
   }
}
