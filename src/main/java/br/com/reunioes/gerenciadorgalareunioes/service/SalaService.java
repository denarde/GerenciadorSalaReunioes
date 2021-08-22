package br.com.reunioes.gerenciadorgalareunioes.service;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;

import java.util.Optional;

public interface SalaService {

    Sala save(Sala sala);

    Optional<Sala> getById(Long id);

    void delete(Sala sala);

    Sala update(Sala sala);
}
