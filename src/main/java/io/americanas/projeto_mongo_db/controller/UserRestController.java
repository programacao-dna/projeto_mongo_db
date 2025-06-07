package io.americanas.projeto_mongo_db.controller;

import io.americanas.projeto_mongo_db.entinty.User;
import io.americanas.projeto_mongo_db.exceptions.UserFoundException;
import io.americanas.projeto_mongo_db.repository.UserRepository;
import io.americanas.projeto_mongo_db.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
//@EnableMongoAuditing
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/teste1")
    public ResponseEntity<String> createUser1(@ModelAttribute User user) {
        // You can save to DB or return JSON
        return ResponseEntity.ok("User received: " + user.getUsername() + ", " + user.getEmail() + ", " + user.getPhone());
    }

    @PostMapping("/teste2")
    public ResponseEntity<String> createUser(@RequestParam String username,
                                             @RequestParam String email,
                                             @RequestParam String phone) {
        // You can save to DB or return JSON
        return ResponseEntity.ok("User received: " + username + ", " + email + ", " + phone);
    }

    @PostMapping("/add/user")
    public ResponseEntity<Object> createUser2(@Valid @RequestBody User userEntity) {
        try{
            var resultado = userService.addNewUser(userEntity);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
