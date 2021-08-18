package br.com.reunioes.gerenciadorgalareunioes.service;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UsuarioService {



    Usuario save(Usuario usr);


    Optional<Usuario> getById(Long id);

    void delete(Usuario usr);

    Usuario update(Usuario usuario);
}
