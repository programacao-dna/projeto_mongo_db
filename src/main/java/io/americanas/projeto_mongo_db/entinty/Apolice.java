package io.americanas.projeto_mongo_db.entinty;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "apolice")
public class Apolice {

    @Id
    private String id;
    private String numeroApolice;
    private String descrico;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorSegurado;
    private List<SubApolice> subApolices = new ArrayList<>();

    /*
    * {
    *   "numeroApolice": "77739c6d-74fd-4c1b-b274-d59be9c1c4d4",
    *   "descrico": "Descrição Apolice Principal Número 77739c6d-74fd-4c1b-b274-d59be9c1c4d4",
    *   "dataInicio": "2024-06-01",
    *   "dataFim": "2025-07-31",
    *   "valorSegurado": 150999.88
    * }
    * */

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public Apolice(String numeroApolice, String descrico, LocalDate dataInicio, LocalDate dataFim, double valorSegurado) {
        this.numeroApolice = numeroApolice;
        this.descrico = descrico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorSegurado = valorSegurado;
    }
}
