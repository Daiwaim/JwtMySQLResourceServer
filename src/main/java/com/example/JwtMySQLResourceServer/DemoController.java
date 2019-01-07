package com.example.JwtMySQLResourceServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import com.example.JwtMySQLResourceServer.User.User;
import com.example.JwtMySQLResourceServer.User.UserRepository;

@RestController
public class DemoController {

    private final UserRepository repository;

    @Autowired
    public DemoController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Principal principal) {
        String tokenSubject = principal.getName();
        User user = repository.findByTokenSubject(tokenSubject);
        return String.format("Hello, %s!", user.getName());
    }
}
