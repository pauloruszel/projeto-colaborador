package br.net.mirante.colaborador.resource;

import br.net.mirante.colaborador.domain.dtos.CompetenciaDTO;
import br.net.mirante.colaborador.exception.ParametroInvalidoException;
import br.net.mirante.colaborador.service.CompetenciaService;
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
@RequestMapping("/competencias")
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @Autowired
    public CompetenciaResource(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService;
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> listarTodos() {
        return ok(competenciaService.listarTodos());
    }


    @GetMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<CompetenciaDTO> buscarPorId(@PathVariable("id") final Long id) throws ParametroInvalidoException {
        final var retorno = competenciaService.buscarPorId(id);
        if(Objects.nonNull(retorno)) {
            return status(OK).body(retorno);
        }
        return ResponseEntity.notFound().build();
    }


}
