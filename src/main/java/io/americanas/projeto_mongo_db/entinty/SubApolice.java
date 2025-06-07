package io.americanas.projeto_mongo_db.entinty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubApolice {

    private String numeroApolice;
    private String descrico;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorSegurado;

    /*
     * {
     *   "numeroApolice": "123456-1",
     *   "descrico": "Descrição Apolice Principal Número 123456",
     *   "dataInicio": "2024-06-01",
     *   "dataFim": "2025-07-31",
     *   "valorSegurado": 200777.99
     * }
     * */

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public SubApolice(String numeroApolice, String descrico, LocalDate dataInicio, LocalDate dataFim, double valorSegurado) {
        this.numeroApolice = numeroApolice;
        this.descrico = descrico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorSegurado = valorSegurado;
    }

}
