package br.com.reunioes.gerenciadorgalareunioes.model.repository;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Agenda;
import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Query(value = "SELECT COUNT(1) FROM AGENDA s " +
            "WHERE s.ID_SALA = :id " +
            "AND ((s.INICIO_REUNIAO = :dateInicio AND  s.FIM_REUNIAO = :dateFim) " +
            "OR (:dateInicio > s.INICIO_REUNIAO AND :dateInicio < s.FIM_REUNIAO)" +
            "OR (:dateFim > s.INICIO_REUNIAO AND :dateFim < s.FIM_REUNIAO))"
            ,
            nativeQuery = true)
    Integer validaHorarioDisponivel(Date dateInicio, Date dateFim, Long id);
}
