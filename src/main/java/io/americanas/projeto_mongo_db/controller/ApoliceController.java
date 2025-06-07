package io.americanas.projeto_mongo_db.controller;

import io.americanas.projeto_mongo_db.entinty.Apolice;
import io.americanas.projeto_mongo_db.entinty.SubApolice;
import io.americanas.projeto_mongo_db.repository.ApoliceRepository;
import io.americanas.projeto_mongo_db.service.ApoliceService;
import jakarta.validation.Valid;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apolice")
@EnableMongoAuditing
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

    @PostMapping("/{numeroParentApolice}")
    public ResponseEntity<Object> addSubapolice(@Valid @PathVariable String numeroParentApolice, @RequestBody SubApolice subApolice) {
        try{
            var retorno =  apoliceService.criarSubApoliceParaApolice(numeroParentApolice, subApolice);
            return ResponseEntity.ok().body(retorno);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Apolice>> getApolices() {
        return ResponseEntity.ok().body(apoliceService.ListarTodasApolices());
    }

    @PostMapping("/{apoliceId}/{subApoliceNumero}")
    public ResponseEntity<Object> atualizarSubApoliceV2(@Valid @PathVariable String apoliceId, @PathVariable String subApoliceNumero, @RequestBody SubApolice subApolice) {
        try{
           var apolice =  apoliceService.atualizarSubApoliceV2(apoliceId, subApoliceNumero, subApolice);
           return ResponseEntity.ok().body(apolice);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
