package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.model.TipoContato;
import br.net.mirante.colaborador.repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContatoService extends BaseService {

    private final TipoContatoRepository tipoContatoRepository;

    @Autowired
    public TipoContatoService(TipoContatoRepository tipoContatoRepository) {
        this.tipoContatoRepository = tipoContatoRepository;
    }

    public void salvar(TipoContato tipoContato) {
        tipoContatoRepository.save(tipoContato);
    }

    public Optional<TipoContato> buscarPorId(Long id) {
        return tipoContatoRepository.findById(id);
    }

    public List<TipoContato> listarTodos() {
        return tipoContatoRepository.findAll();
    }


}
