package br.com.reunioes.gerenciadorgalareunioes.service.impl;

import br.com.reunioes.gerenciadorgalareunioes.api.dto.AgendaDTO;
import br.com.reunioes.gerenciadorgalareunioes.exception.BusinessException;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Agenda;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Usuario;
import br.com.reunioes.gerenciadorgalareunioes.model.repository.AgendaRepository;
import br.com.reunioes.gerenciadorgalareunioes.service.AgendaService;
import br.com.reunioes.gerenciadorgalareunioes.service.SalaService;
import br.com.reunioes.gerenciadorgalareunioes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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


        Sala sala = salaService.getById(dto.getSala()).orElseThrow(() ->
                new BusinessException("Sala não encontrada"));
        Usuario usuario = usuarioService.getById(dto.getUsuario()).orElseThrow(() ->
                new BusinessException("Usuario não encontrado"));

        Date dateInicio = formatData.parse(dto.getInicio());
        Date dateFim = formatData.parse(dto.getFim());

        if(!salaService.isCapacidade(dto.getQtdParticipantes(), sala.getId())){
            throw new BusinessException("Quantidade de participantes maior do que o permitido");
        }

        if(dateInicio.getDay() != dateFim.getDay()){
            throw new BusinessException("Agenda não permitida para dias diferentes");
        }

        if(!salaService.isHorarioPermitido(dateInicio,dateFim,sala)){
            throw new BusinessException("Agenda fora do horario de atendimento da Sala");
        }

        if(dateFim.getHours() < dateInicio.getHours()){
            throw new BusinessException("Horario de fim não pode ser menor que o horario de inicio");
        }

        if(!isHorarioDisponivel(dateInicio, dateFim, sala.getId())){
            throw new BusinessException("Horario indisponivel para agendamento");
        }




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

    private Boolean isHorarioDisponivel(Date dateInicio, Date dateFim, Long idSala) {

        return agendaRepository.validaHorarioDisponivel(dateInicio, dateFim, idSala) == 0;
    }

    @Override
    public Optional<Agenda> getById(Long id) {
        return Optional.of(agendaRepository.getById(id));
    }

    @Override
    public void delete(Agenda agenda) {
        agendaRepository.delete(agenda);
    }

}
