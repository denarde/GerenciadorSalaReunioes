package br.com.reunioes.gerenciadorgalareunioes.service.impl;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.SalaRepository;
import br.com.reunioes.gerenciadorgalareunioes.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository repository;

    @Autowired
    @Qualifier("formatHora")
    private final SimpleDateFormat formatHora;

    @Autowired
    @Qualifier("formatData")
    private final SimpleDateFormat formatData;

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

    @Override
    public Boolean isCapacidade(Integer participantes, Long id) {

        return repository.validaCapacidade(participantes, id);
    }

    @Override
    public Boolean isHorarioPermitido(Date inicio, Date fim, Sala sala) throws ParseException {

        if(sala.getHorarioAbertura().getHours() <= inicio.getHours() &&
                sala.getHorarioFechamento().getHours() >=  fim.getHours()){
            return true;
        }
        return false;

    }


}
