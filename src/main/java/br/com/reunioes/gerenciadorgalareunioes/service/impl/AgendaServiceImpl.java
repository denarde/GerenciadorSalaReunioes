package br.com.reunioes.gerenciadorgalareunioes.service.impl;

import br.com.reunioes.gerenciadorgalareunioes.api.dto.AgendaDTO;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Agenda;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.AgendaRepository;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.SalaRepository;
import br.com.reunioes.gerenciadorgalareunioes.service.AgendaService;
import br.com.reunioes.gerenciadorgalareunioes.service.SalaService;
import br.com.reunioes.gerenciadorgalareunioes.service.UsuarioService;
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
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final SalaService salaService;
    private final UsuarioService usuarioService;

    @Autowired
    @Qualifier("formatData")
    private final SimpleDateFormat formatData;
    
    @Override
    public Agenda agendar(AgendaDTO dto) throws ParseException {

        System.out.println(dto.toString());

        Sala sala = salaService.getById(dto.getSala()).get();

        Usuario usuario = usuarioService.getById(dto.getUsuario()).get();

        Date dateInicio = formatData.parse(dto.getInicio());

        Date dateFim = formatData.parse(dto.getFim());

        Agenda agenda = Agenda.builder()
                                .descricao(dto.getDescricao())
                                .qtdParticipantes(dto.getQtdParticipantes())
                                .sala(sala)
                                .inico(dateInicio)
                                .fim(dateFim)
                                .usuario(usuario)
                                .build();


        return agendaRepository.save(agenda);
    }

    @Override
    public Optional<Agenda> getById(Long id) {



        return Optional.of(agendaRepository.getById(id));
    }

    @Override
    public void delete(Agenda agenda) {
        agendaRepository.delete(agenda);
    }

    @Override
    public Agenda update(Agenda agenda) {
        return null;
    }
}
