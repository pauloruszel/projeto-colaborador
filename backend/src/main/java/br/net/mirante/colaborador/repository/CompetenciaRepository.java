package br.net.mirante.colaborador.repository;

import br.net.mirante.colaborador.domain.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
}
