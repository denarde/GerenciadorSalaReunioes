package br.com.reunioes.gerenciadorgalareunioes.service.impl;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.UsuarioRepository;
import br.com.reunioes.gerenciadorgalareunioes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    @Override
    public Usuario save(Usuario usr) {
        return repository.save(usr);
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return Optional.of(this.repository.getById(id));
    }

    @Override
    public void delete(Usuario usr) {
        repository.delete(usr);
    }

    @Override
    public Usuario update(Usuario usuario) {
       return repository.save(usuario);
    }

}
