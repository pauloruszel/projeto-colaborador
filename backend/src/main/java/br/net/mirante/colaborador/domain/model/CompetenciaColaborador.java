package br.net.mirante.colaborador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "idCompetenciaColaborador", unique = true, nullable = false, length = 4, precision = 10))
public class CompetenciaColaborador extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "idCompetencia", referencedColumnName = "idcompetencia")
    private Competencia competencia;

    @ManyToOne
    @JoinColumn(name = "idColaborador", referencedColumnName = "idcolaborador")
    private Colaborador colaborador;

}
