package br.net.mirante.colaborador.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaDTO implements BaseDTO {

    private Long id;
    private String nomeCompetencia;

}
