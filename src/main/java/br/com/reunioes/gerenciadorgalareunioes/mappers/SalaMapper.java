package br.com.reunioes.gerenciadorgalareunioes.mappers;

import br.com.reunioes.gerenciadorgalareunioes.api.dto.SalaDTO;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaMapper

{
    SimpleDateFormat formHora = new SimpleDateFormat("HH:mm:ss");

    public Sala mapEntity(SalaDTO dto) throws ParseException {

        Date dateAbertura = formHora.parse(dto.getHorarioAbertura());
        Date dateFechamento = formHora.parse(dto.getHorarioFechamento());

        return Sala.builder()
                .nome(dto.getNome())
                .horarioAbertura(dateAbertura)
                .horarioFechamento(dateFechamento)
                .capacidade(dto.getCapacidade()).build();

    }

    public SalaDTO mapDTO(Sala sala){

        return SalaDTO.builder()
                .capacidade(sala.getCapacidade())
                .id(sala.getId())
                .nome(sala.getNome())
                .horarioAbertura(formHora.format(sala.getHorarioAbertura()))
                .horarioFechamento(formHora.format(sala.getHorarioFechamento()))
                .build();

    }
}
