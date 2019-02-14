package com.example.JwtMySQLResourceServer.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true, nullable=false)
    private String tokenSubject;
    private String name;
    @Transient
    private List<GrantedAuthority> authorities = new ArrayList<>();

    protected User() {}

    public User(String tokenSubject) {
        this.tokenSubject = tokenSubject;
    }

    public Long getId() { return id; }
    public String getTokenSubject() { return tokenSubject; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override public String getUsername() {
        return tokenSubject;
    }
    @Override public String getPassword() {
        return null;
    }
    @Override public boolean isAccountNonExpired() {
        return true;
    }
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override public boolean isEnabled() {
        return true;
    }
}
