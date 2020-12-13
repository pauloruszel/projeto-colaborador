package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.model.Competencia;
import br.net.mirante.colaborador.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciaService extends BaseService {

    private final CompetenciaRepository competenciaRepository;

    @Autowired
    public CompetenciaService(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    public void salvar(Competencia competencia) {
        competenciaRepository.save(competencia);
    }

    public Optional<Competencia> buscarPorId(Long id){
        return competenciaRepository.findById(id);
    }

    public List<Competencia> listarTodos(){
        return competenciaRepository.findAll();
    }

    public void deletar(Long id){ competenciaRepository.deleteById(id);}

}
