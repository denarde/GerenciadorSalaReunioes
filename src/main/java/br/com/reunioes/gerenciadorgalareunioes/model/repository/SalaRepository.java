package br.com.reunioes.gerenciadorgalareunioes.model.repository;

import br.com.reunioes.gerenciadorgalareunioes.model.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query(value = "SELECT CASE WHEN COUNT(1) = 1 THEN TRUE ELSE FALSE END AS CAP FROM SALA s " +
                    "WHERE s.id = :id " +
                    "AND s.capacidade >= :participantes",
            nativeQuery = true)
    Boolean validaCapacidade(Integer participantes, Long id);

}
