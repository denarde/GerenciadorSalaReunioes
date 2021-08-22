package br.com.reunioes.gerenciadorgalareunioes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Sala {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(name = "HORARIO_ABERTURA")
    @Temporal(TemporalType.TIME)
    private Date horarioAbertura;

    @Column(name = "HORARIO_FECHAMENTO")
    @Temporal(TemporalType.TIME)
    private Date horarioFechamento;

    @Column
    private Integer capacidade;

}
