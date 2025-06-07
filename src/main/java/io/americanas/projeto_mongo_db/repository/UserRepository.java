package io.americanas.projeto_mongo_db.repository;

import io.americanas.projeto_mongo_db.entinty.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @Query(collation = "pt")
    Optional<User> findByUsernameOrEmail(String username, String email);

    @Query(collation = "pt")
    Optional<User> findByUsername(String username);
}
