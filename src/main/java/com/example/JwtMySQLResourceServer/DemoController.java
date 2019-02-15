package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.CurrentUser;
import com.example.JwtMySQLResourceServer.User.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtMySQLResourceServer.User.User;

@RestController
public class DemoController {

    private final CurrentUserService currentUserService;

    @Autowired
    public DemoController(CurrentUserService currentUserService) {
        this.currentUserService = currentUserService;
    }

    @GetMapping("/")
    public String index(@CurrentUser User user) {
        return String.format("Hello, %s!", user.getTokenSubject());
    }
}
