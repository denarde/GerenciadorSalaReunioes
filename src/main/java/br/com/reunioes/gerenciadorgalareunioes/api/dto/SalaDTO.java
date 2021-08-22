package br.com.reunioes.gerenciadorgalareunioes.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {


    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String horarioAbertura;

    @NotEmpty
    private String horarioFechamento;


    private Integer capacidade;

}
