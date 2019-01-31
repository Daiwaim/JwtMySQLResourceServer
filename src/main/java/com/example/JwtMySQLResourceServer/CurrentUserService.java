package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.User;
import com.example.JwtMySQLResourceServer.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {

    private final UserRepository repository;

    @Autowired
    public CurrentUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(String tokenSubject) {
        User user = repository.findByTokenSubject(tokenSubject);
        if(user == null) {
            user = new User(tokenSubject);
            user = repository.save(user);
        }
        return user;
    }
}
