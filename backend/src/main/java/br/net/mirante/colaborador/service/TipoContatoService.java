package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.dtos.TipoContatoDTO;
import br.net.mirante.colaborador.domain.model.TipoContato;
import br.net.mirante.colaborador.domain.util.MensagemUtil;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(Transactional.TxType.NOT_SUPPORTED)
public class TipoContatoService extends BaseService {

    private final TipoContatoRepository tipoContatoRepository;

    @Autowired
    public TipoContatoService(TipoContatoRepository tipoContatoRepository) {
        this.tipoContatoRepository = tipoContatoRepository;
    }

    public List<TipoContatoDTO> listarTodos(){
        return tipoContatoRepository.findAll()
                .stream().map(tipoContato -> getConverter().map(tipoContato, TipoContatoDTO.class))
                .collect(Collectors.toList());
    }

    public TipoContatoDTO buscarPorId(Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Optional<TipoContato> tipoContato = tipoContatoRepository.findById(id);
        if (tipoContato.isEmpty())
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(tipoContato.get(), TipoContatoDTO.class);
    }

}
