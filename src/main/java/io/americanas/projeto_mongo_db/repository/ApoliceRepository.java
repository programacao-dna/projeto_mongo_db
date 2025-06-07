package io.americanas.projeto_mongo_db.repository;

import io.americanas.projeto_mongo_db.entinty.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApoliceRepository extends MongoRepository<Apolice, String> {

    @Query(collation = "pt")
    public Optional<Apolice> findByNumeroApolice(String numeroApolice);

}
