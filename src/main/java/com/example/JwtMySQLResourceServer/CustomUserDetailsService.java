package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.User;
import com.example.JwtMySQLResourceServer.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String tokenSubject) {
        User user = repository.findByTokenSubject(tokenSubject);
        if (user == null) {
            user = new User(tokenSubject);
            user = repository.save(user);
        }
        return new CustomUserDetails(user);
    }
}
