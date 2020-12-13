package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.model.Endereco;
import br.net.mirante.colaborador.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService extends BaseService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void salvar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }


}
