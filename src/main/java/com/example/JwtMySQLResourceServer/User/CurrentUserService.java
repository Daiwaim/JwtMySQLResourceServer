package com.example.JwtMySQLResourceServer.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {

    private final UserRepository repository;

    @Autowired
    public CurrentUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser() {
        String tokenSubject = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = repository.findByTokenSubject(tokenSubject);
        if(user == null) {
            user = new User(tokenSubject);
            user = repository.save(user);
        }
        return user;
    }
}
