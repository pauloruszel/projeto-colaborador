package br.net.mirante.colaborador.repository;

import br.net.mirante.colaborador.domain.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Optional<Colaborador> findByNomeCargo(@Param("cargo") String cargo);

    Optional<Colaborador> findByNomeTime(@Param("time") String time);

}
