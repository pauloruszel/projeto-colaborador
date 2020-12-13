package br.net.mirante.colaborador.resource;

import br.net.mirante.colaborador.domain.dtos.ColaboradorDTO;
import br.net.mirante.colaborador.domain.dtos.MensagemRetornoDTO;
import br.net.mirante.colaborador.domain.util.MensagemUtil;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorResource(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listarTodosAlunos() {
        return ok(colaboradorService.listarTodos());
    }


    @GetMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ColaboradorDTO> buscarPorId(@PathVariable("id") final Long id) throws ParametroInvalidoException {
        final var retorno = colaboradorService.buscarPorId(id);
        if(Objects.nonNull(retorno)) {
            return status(OK).body(retorno);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvar(@Valid @RequestBody ColaboradorDTO colaboradorDTO) throws ParametroInvalidoException {
        ColaboradorDTO retorno = colaboradorService.salvar(colaboradorDTO);
        return status(CREATED).body(retorno);
    }

    @PutMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ColaboradorDTO> atualizar(@PathVariable(value = "id") final Long id,
                                                    @Valid @RequestBody ColaboradorDTO colaboradorDTO) throws ParametroInvalidoException {
        ColaboradorDTO retorno = colaboradorService.update(id, colaboradorDTO);
        if (Objects.nonNull(retorno)) {
            return status(OK).body(retorno);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<MensagemRetornoDTO> deletar(@PathVariable final Long id) throws ParametroInvalidoException {
        final var mensagemRetornoDTO = colaboradorService.deletar(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return status(OK).body(mensagemRetornoDTO);
        }
        return status(NOT_FOUND).body(mensagemRetornoDTO);

    }



}
