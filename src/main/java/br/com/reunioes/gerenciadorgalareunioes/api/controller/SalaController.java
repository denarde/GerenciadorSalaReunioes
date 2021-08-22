package br.com.reunioes.gerenciadorgalareunioes.api.controller;


import br.com.reunioes.gerenciadorgalareunioes.api.dto.SalaDTO;
import br.com.reunioes.gerenciadorgalareunioes.mappers.SalaMapper;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaMapper salaMapper;
    private final SalaService service;
    private final SimpleDateFormat formHora;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalaDTO create(@RequestBody @Valid SalaDTO dto) throws ParseException {

        Sala sala = salaMapper.mapEntity(dto);

        sala = service.save(sala);

        return salaMapper.mapDTO(sala);
    }

    @GetMapping("{id}")
    public SalaDTO get(@PathVariable Long id){

        return service
                .getById(id)
                .map( sala -> salaMapper.mapDTO(sala) )
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        Sala sala = service.getById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
        service.delete(sala);
    }

    @PutMapping("{id}")
    public SalaDTO update(@PathVariable Long id, @RequestBody @Valid SalaDTO dto) throws ParseException {

        Date dateAbertura = formHora.parse(dto.getHorarioAbertura());
        Date dateFechamento = formHora.parse(dto.getHorarioFechamento());

        return service.getById(id).map( sala -> {

                    sala.setCapacidade(dto.getCapacidade());
                    sala.setHorarioFechamento(dateFechamento);
                    sala.setHorarioAbertura(dateAbertura);
                    sala.setNome(dto.getNome());

                    sala = service.update(sala);

                    return salaMapper.mapDTO(sala);

                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

}

