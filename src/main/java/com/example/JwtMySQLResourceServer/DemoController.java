package com.example.JwtMySQLResourceServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtMySQLResourceServer.User.User;
import com.example.JwtMySQLResourceServer.User.UserRepository;

@RestController
public class DemoController {

    private final UserRepository repository;
    private final CurrentUserService currentUserService;

    @Autowired
    public DemoController(UserRepository repository, CurrentUserService currentUserService) {
        this.repository = repository;
        this.currentUserService = currentUserService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal String tokenSubject) {
        User user = currentUserService.getUser(tokenSubject);
        return String.format("Hello, %s!", user.getName());
    }
}
