package br.net.mirante.colaborador.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaColaboradorDTO implements BaseDTO {

    private Long id;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<CompetenciaDTO> competencias;

    private ColaboradorDTO colaborador;

}
