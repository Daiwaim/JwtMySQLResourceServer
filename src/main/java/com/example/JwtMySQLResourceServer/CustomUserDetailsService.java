package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.User;
import com.example.JwtMySQLResourceServer.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String tokenSubject) {
        System.out.println("working...");
        User user = repository.findByTokenSubject(tokenSubject);
        if (user == null) {
            user = new User(tokenSubject);
            user = repository.save(user);
        }
        return user;
    }

    /*
    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPrivileges().stream().map(
                p -> new SimpleGrantedAuthority(p.getName())
            ).forEach(authorities::add);
        }
        return authorities;
    }
    */
}
