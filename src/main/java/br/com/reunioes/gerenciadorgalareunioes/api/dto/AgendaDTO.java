package br.com.reunioes.gerenciadorgalareunioes.api.dto;


import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDTO {


    private Long id;

    private String descricao;

    private String inicio;

    private String fim;

    private Integer qtdParticipantes;

    private Long sala;

    private Long usuario;

}
