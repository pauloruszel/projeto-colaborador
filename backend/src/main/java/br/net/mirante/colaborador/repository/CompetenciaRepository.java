package br.net.mirante.colaborador.repository;

import br.net.mirante.colaborador.domain.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {

    @Query("SELECT c FROM Competencia c " +
            "INNER JOIN CompetenciaColaborador cc " +
            "ON c.id = cc.competencia.id " +
            "WHERE cc.colaborador.id = :idColaborador")
    List<Competencia> findAllCompetenciasByIdColaborador(@Param("idColaborador") Long idColaborador);
}
