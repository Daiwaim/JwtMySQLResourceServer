package com.example.JwtMySQLResourceServer;

import com.example.JwtMySQLResourceServer.User.CurrentUser;
import com.example.JwtMySQLResourceServer.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JwtMySQLResourceServer.User.User;

@RestController
public class DemoController {

    private final UserRepository repository;

    @Autowired
    public DemoController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(@CurrentUser User user) {
        return String.format("Hello, %s!", user.getTokenSubject());
    }

    @GetMapping("/hello")
    public String hello(@CurrentUser User user) {
        return String.format("Hello, %s!", user.getName());     // On fait quoi s'il y a pas de name? Faut-il en mettre un par défaut?
    }

    @PutMapping("/updateName")
    public ResponseEntity updateName(@CurrentUser User user, @RequestBody String name) {
        user.setName(name);
        return new ResponseEntity<>(repository.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>("user " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
