package io.americanas.projeto_mongo_db.exceptions;

public class ApoliceNotFoundException extends RuntimeException {
    public ApoliceNotFoundException() {
        super("Apólice não localizada em nossa base de dados.");
    }
}
