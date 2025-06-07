package io.americanas.projeto_mongo_db.exceptions;

public class SubApoliceNotFoundException extends RuntimeException {
    public SubApoliceNotFoundException() {
        super("Sub-Apolice não localizada em nossa base de dados.");
    }
}
