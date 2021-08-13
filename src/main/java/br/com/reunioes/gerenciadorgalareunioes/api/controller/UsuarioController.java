package br.com.reunioes.gerenciadorgalareunioes.api.controller;


import br.com.reunioes.gerenciadorgalareunioes.api.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody @Valid UsuarioDTO dto){
        // TODO: 12/08/2021

        return dto;
    }

    @GetMapping("{id}")
    public UsuarioDTO get(@PathVariable Long id){
        // TODO: 12/08/2021

        return null;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        // TODO: 12/08/2021
    }

    @PutMapping("{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO dto){
        // TODO: 12/08/2021
        return null;
    }

}

