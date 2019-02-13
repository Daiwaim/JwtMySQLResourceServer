package com.example.JwtMySQLResourceServer;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtMySQLResourceServer.User.User;

@RestController
public class DemoController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user) {
        return String.format("Hello, %s!", user.getName());
    }
}
