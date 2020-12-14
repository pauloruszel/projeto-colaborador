package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.dtos.CompetenciaDTO;
import br.net.mirante.colaborador.domain.model.Competencia;
import br.net.mirante.colaborador.domain.util.MensagemUtil;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(Transactional.TxType.NOT_SUPPORTED)
public class CompetenciaService extends BaseService {

    private final CompetenciaRepository competenciaRepository;

    @Autowired
    public CompetenciaService(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    public List<CompetenciaDTO> listarTodos(){
        return competenciaRepository.findAll()
                .stream().map(competencia -> getConverter().map(competencia, CompetenciaDTO.class))
                .collect(Collectors.toList());
    }

    public CompetenciaDTO buscarPorId(Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Optional<Competencia> competencia = competenciaRepository.findById(id);
        if (competencia.isEmpty())
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(competencia.get(), CompetenciaDTO.class);
    }

}
