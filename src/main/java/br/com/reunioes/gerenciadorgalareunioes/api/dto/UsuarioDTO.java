package br.com.reunioes.gerenciadorgalareunioes.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cargo;

    @NotEmpty
    private String email;

}
