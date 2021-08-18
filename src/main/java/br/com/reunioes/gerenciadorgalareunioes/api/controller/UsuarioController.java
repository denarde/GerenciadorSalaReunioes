package br.com.reunioes.gerenciadorgalareunioes.api.controller;


import br.com.reunioes.gerenciadorgalareunioes.api.dto.UsuarioDTO;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final ModelMapper modelMapper;
    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody @Valid UsuarioDTO dto){

        Usuario usr = modelMapper.map(dto,Usuario.class);
        usr = service.save(usr);
        
        return modelMapper.map(usr,UsuarioDTO.class);
    }

    @GetMapping("{id}")
    public UsuarioDTO get(@PathVariable Long id){

        return service
                .getById(id)
                .map( usuario -> modelMapper.map(usuario, UsuarioDTO.class) )
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        Usuario usr = service.getById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
        service.delete(usr);
    }

    @PutMapping("{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO dto){

        return service.getById(id).map( usuario -> {

                    usuario.setCargo(dto.getCargo());
                    usuario.setEmail(dto.getEmail());
                    usuario.setNome(dto.getNome());

                    usuario = service.update(usuario);

                    return modelMapper.map(usuario, UsuarioDTO.class);

                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

}

