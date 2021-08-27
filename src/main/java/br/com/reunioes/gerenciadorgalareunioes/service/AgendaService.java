package br.com.reunioes.gerenciadorgalareunioes.service;

import br.com.reunioes.gerenciadorgalareunioes.api.dto.AgendaDTO;
import br.com.reunioes.gerenciadorgalareunioes.exception.BusinessException;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Agenda;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public interface AgendaService {

    Agenda agendar(AgendaDTO dto) throws ParseException, BusinessException;

    Optional<Agenda> getById(Long id);

    void delete(Agenda agenda);

}
