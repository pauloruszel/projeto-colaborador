package br.net.mirante.colaborador.resource;

import br.net.mirante.colaborador.domain.dtos.TipoContatoDTO;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.service.TipoContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/tipocontatos")
public class TipoContatoResource {

    private final TipoContatoService tipoContatoService;

    @Autowired
    public TipoContatoResource(TipoContatoService tipoContatoService) {
        this.tipoContatoService = tipoContatoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoContatoDTO>> listarTodos() {
        return ok(tipoContatoService.listarTodos());
    }


    @GetMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<TipoContatoDTO> buscarPorId(@PathVariable("id") final Long id) throws ParametroInvalidoException {
        final var retorno = tipoContatoService.buscarPorId(id);
        if(Objects.nonNull(retorno)) {
            return status(OK).body(retorno);
        }
        return ResponseEntity.notFound().build();
    }


}
