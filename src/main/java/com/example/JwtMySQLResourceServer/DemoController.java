package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.CurrentUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtMySQLResourceServer.User.User;

@RestController
public class DemoController {

    @GetMapping("/")
    public String index(@CurrentUser User user) {
        return String.format("Hello, %s!", user.getTokenSubject());
    }
}
