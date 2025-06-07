package io.americanas.projeto_mongo_db.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuario já existe na base de dados");
    }
}
