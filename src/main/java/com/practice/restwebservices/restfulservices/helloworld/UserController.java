package com.practice.restwebservices.restfulservices.helloworld;

import com.practice.restwebservices.restfulservices.UserNotFoundException;
import jakarta.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
//
//    @Autowired
//    UserDao userDao;
//
//    @GetMapping(path = "/users")
//    public List<User> retrieveAllUsers() {
//        return userDao.findAll();
//    }
//
//    @GetMapping(path = "/users/{id}")
//    public EntityModel<User> findOne(@PathVariable Integer id) {
//        User user = userDao.findOne(id);
//        if(user == null)
//            throw new UserNotFoundException("id"+id);
//        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        EntityModel<User> userEntityModel = EntityModel.of(user);
//        userEntityModel.add(linkBuilder.withRel("Fetch all Users"));
//        return userEntityModel;
//    }
//
//    @PostMapping(path = "/users")
//    public ResponseEntity addUser(@Valid @RequestBody User user) {
//        User createdUser = userDao.addOne(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping(path = "remove-user/{id}")
//    public void deleteUser(@PathVariable Integer id){
//        userDao.deleteById(id);
//    }

}