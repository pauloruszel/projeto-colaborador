package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.dtos.ColaboradorDTO;
import br.net.mirante.colaborador.domain.dtos.MensagemRetornoDTO;
import br.net.mirante.colaborador.domain.model.Colaborador;
import br.net.mirante.colaborador.domain.util.MensagemUtil;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService extends BaseService {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    @Transactional
    public ColaboradorDTO salvar(final ColaboradorDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Colaborador colaborador = getConverter().map(dto, Colaborador.class);
        colaboradorRepository.save(colaborador);
        return getConverter().map(colaborador, ColaboradorDTO.class);
    }

    @Transactional
    public ColaboradorDTO update(final Long id, final ColaboradorDTO dto) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        if (dto == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty())
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        var colaboradorEditado = getConverter().map(dto, Colaborador.class);
        colaboradorEditado.setId(id);
        colaboradorRepository.save(colaboradorEditado);
        return getConverter().map(colaboradorEditado, ColaboradorDTO.class);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ColaboradorDTO buscarPorId(Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty())
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(colaborador.get(), ColaboradorDTO.class);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<ColaboradorDTO> listarTodos(){
        return colaboradorRepository.findAll()
                .stream().map(colaborador -> getConverter().map(colaborador, ColaboradorDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Optional<Colaborador> buscarPorCargo(String nomeCargo){
        return colaboradorRepository.findByNomeCargo(nomeCargo);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Optional<Colaborador> buscarPorTime(String nomeTime){
        return colaboradorRepository.findByNomeTime(nomeTime);
    }

    @Transactional
    public MensagemRetornoDTO deletar(Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty())
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        colaboradorRepository.deleteById(id);
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }

}
