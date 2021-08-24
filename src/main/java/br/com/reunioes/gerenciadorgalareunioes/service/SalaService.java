package br.com.reunioes.gerenciadorgalareunioes.service;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public interface SalaService {

    Sala save(Sala sala);

    Optional<Sala> getById(Long id);

    void delete(Sala sala);

    Sala update(Sala sala);

    Boolean isCapacidade(Integer participantes, Long id);

    Boolean isHorarioPermitido(Date inicio, Date fim, Sala sala) throws ParseException;

}
