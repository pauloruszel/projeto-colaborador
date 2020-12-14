package br.net.mirante.colaborador.service;

import br.net.mirante.colaborador.domain.dtos.ColaboradorDTO;
import br.net.mirante.colaborador.domain.dtos.ContatoDTO;
import br.net.mirante.colaborador.domain.dtos.MensagemRetornoDTO;
import br.net.mirante.colaborador.domain.model.Colaborador;
import br.net.mirante.colaborador.domain.util.MensagemUtil;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.repository.ColaboradorRepository;
import br.net.mirante.colaborador.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService extends BaseService {

    private final ColaboradorRepository colaboradorRepository;
    private final ContatoRepository contatoRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository, ContatoRepository contatoRepository) {
        this.colaboradorRepository = colaboradorRepository;
        this.contatoRepository = contatoRepository;
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

        List<ContatoDTO> contatos = getContatosPorIdColaborador(id);
        final var colaboradorDTO = getConverter().map(colaborador.get(), ColaboradorDTO.class);
        colaboradorDTO.setContatos(contatos);

        return colaboradorDTO;
    }

    @NotNull
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    List<ContatoDTO> getContatosPorIdColaborador(Long id) {
        return contatoRepository.findAllContatosByIdColaborador(id)
                .stream().map(contato -> getConverter().map(contato, ContatoDTO.class))
                .collect(Collectors.toList());
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

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Optional<Colaborador> buscarPorNome(String nomeTime){
        return colaboradorRepository.findByNome(nomeTime);
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
