package io.americanas.projeto_mongo_db.controller;

import io.americanas.projeto_mongo_db.entinty.Apolice;
import io.americanas.projeto_mongo_db.entinty.SubApolice;
import io.americanas.projeto_mongo_db.repository.ApoliceRepository;
import io.americanas.projeto_mongo_db.service.ApoliceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apolice")
public class ApoliceController {

    private final ApoliceService apoliceService;

    public ApoliceController(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody Apolice apolice) {
        try{
            var retorno =  apoliceService.criarApolice(apolice);
            return ResponseEntity.ok().body(retorno);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> addSubapolice(@Valid @RequestBody String numeroApolice, SubApolice subApolice) {
        try{
            var retorno =  apoliceService.criarSubApoliceParaApolice(numeroApolice, subApolice);
            return ResponseEntity.ok().body(retorno);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
