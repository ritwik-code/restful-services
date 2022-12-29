package com.practice.restwebservices.restfulservices.helloworld;

import com.practice.restwebservices.restfulservices.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {

    @Autowired
    UserJPARepository userRepository;

    @Autowired
    PostJPARepository postRepository;

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> findOne(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id"+id);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> userEntityModel = EntityModel.of(user.get());
        userEntityModel.add(linkBuilder.withRel("Fetch all Users"));
        return userEntityModel;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        User createdUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id"+id);
        return user.get().getPosts();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostsForUser(@PathVariable int id, @RequestBody Post post){
        Optional<User> userOption = userRepository.findById(id);
        if(userOption.isEmpty())
            throw new UserNotFoundException("id"+id);
        User user = userOption.get();
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost).toUri();
        return ResponseEntity.created(location).build();
    }
}