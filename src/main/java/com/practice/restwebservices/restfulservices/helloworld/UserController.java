package com.practice.restwebservices.restfulservices.helloworld;

import com.practice.restwebservices.restfulservices.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDao.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User findOne(@PathVariable Integer id) {
        User user = userDao.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id"+id);
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity addUser(@RequestBody User user) {
        User createdUser = userDao.addOne(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "remove-user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userDao.deleteOne(id);
//        return ResponseEntity.created().build();
    }

}