package br.com.reunioes.gerenciadorgalareunioes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Agenda implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @Column(name = "HORARIO_ABERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inico;

    @Column(name = "HORARIO_FECHAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;

    @Column
    private Integer qtdParticipantes;

    @JoinColumn(name = "id_sala")
    @OneToOne
    private Sala sala;

    @JoinColumn(name = "id_usuario")
    @OneToOne
    private Usuario usuario;

}
