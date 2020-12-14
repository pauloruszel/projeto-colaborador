package br.net.mirante.colaborador.repository;

import br.net.mirante.colaborador.domain.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c " +
            "INNER JOIN ColaboradorContato cc " +
            "ON c.id = cc.contato.id " +
            "WHERE cc.colaborador.id = :idColaborador")
    List<Contato> findAllContatosByIdColaborador(@Param("idColaborador") Long idColaborador);
}
