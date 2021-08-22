package br.com.reunioes.gerenciadorgalareunioes.service.impl;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.SalaRepository;
import br.com.reunioes.gerenciadorgalareunioes.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository repository;


    @Override
    public Sala save(Sala sala) {

        return repository.save(sala);

    }

    @Override
    public Optional<Sala> getById(Long id) {
        return Optional.of(this.repository.getById(id));
    }

    @Override
    public void delete(Sala sala) {
        repository.delete(sala);
    }

    @Override
    public Sala update(Sala sala) {

        return repository.save(sala);

    }


}
