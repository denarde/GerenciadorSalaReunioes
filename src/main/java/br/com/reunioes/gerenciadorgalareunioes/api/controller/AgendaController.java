package br.com.reunioes.gerenciadorgalareunioes.api.controller;


import br.com.reunioes.gerenciadorgalareunioes.api.dto.AgendaDTO;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Agenda;
import br.com.reunioes.gerenciadorgalareunioes.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;
    private final ModelMapper modelMapper;

    @Autowired
    @Qualifier("formatData")
    private final SimpleDateFormat formatData;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Valid AgendaDTO dto) throws ParseException {

        Agenda agenda = agendaService.agendar(dto);

        return agenda.getId();
    }

    @GetMapping("{id}")
    public AgendaDTO get(@PathVariable Long id){

        return agendaService
                .getById(id)
                .map( agenda -> AgendaDTO.builder()
                                    .sala(agenda.getSala().getId())
                                    .usuario(agenda.getUsuario().getId())
                                    .descricao(agenda.getDescricao())
                                    .inicio(formatData.format(agenda.getInico()))
                                    .fim(formatData.format(agenda.getFim()))
                                    .id(agenda.getId())
                                    .qtdParticipantes(agenda.getQtdParticipantes())
                                    .build()
                )
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        Agenda agenda = agendaService.getById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
        agendaService.delete(agenda);
    }

}

