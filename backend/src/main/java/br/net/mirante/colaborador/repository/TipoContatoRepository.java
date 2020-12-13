package br.net.mirante.colaborador.repository;

import br.net.mirante.colaborador.domain.model.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Long> {
}
