package io.americanas.projeto_mongo_db.service;

import io.americanas.projeto_mongo_db.entinty.User;
import io.americanas.projeto_mongo_db.exceptions.UserFoundException;
import io.americanas.projeto_mongo_db.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addNewUser(User userEntity) {
        this.userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail())
                .ifPresent(user -> {
            throw new UserFoundException();
        });

        return this.userRepository.save(userEntity);
    }

//    public void registerUser(User userEntity) {
//        this.userRepository.findByUsername(userEntity.getUsername()).ifPresent(user -> {
//            throw new UserFoundException();
//        });
//
//        // proceed to save the new user
//        userRepository.save(userEntity);
//    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
