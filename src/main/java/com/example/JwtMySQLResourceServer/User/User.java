package com.example.JwtMySQLResourceServer.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true, nullable=false)
    private String tokenSubject;
    private String name;

    User() {}

    User(String tokenSubject) {
        this.tokenSubject = tokenSubject;
    }

    public Long getId() { return id; }
    public String getTokenSubject() { return tokenSubject; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
