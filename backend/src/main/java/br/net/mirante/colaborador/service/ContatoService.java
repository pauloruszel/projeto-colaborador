package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.model.Contato;
import br.net.mirante.colaborador.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService extends BaseService {

    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public void salvar(Contato contato) {
        contatoRepository.save(contato);
    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }


}
