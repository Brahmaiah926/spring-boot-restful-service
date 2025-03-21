package com.ganna.learn.spring_boot_restful_service.user;

import com.ganna.learn.spring_boot_restful_service.jpa.PostRepository;
import com.ganna.learn.spring_boot_restful_service.jpa.UserRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository= postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundExpection("id: "+ id);

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
       userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundExpection("id: "+ id);

        return user.get().getPosts();
    }

    @GetMapping("/jpa/users/{id}/posts/{post_id}")
    public Post retrievePostOfUser(@PathVariable int id, @PathVariable int post_id) {
        Optional<User> user = userRepository.findById(id);
        Optional<Post> post = postRepository.findById(post_id);
        if(user.isEmpty())
            throw new UserNotFoundExpection("id: "+ id);

       boolean isPostofUser = user.get().getPosts().contains(post.get());
       if(!isPostofUser){
          post = Optional.empty();
       }
        return post.get();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Entity> createPostForUser(@PathVariable int id, @Valid  @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundExpection("id: "+ id);

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
