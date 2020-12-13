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
@AttributeOverride(name = "id", column = @Column(name = "idColaboradorContato", unique = true, nullable = false, length = 4, precision = 10))
public class ColaboradorContato extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "idContato", referencedColumnName = "idcontato")
    private Contato contato;

    @ManyToOne
    @JoinColumn(name = "idColaborador", referencedColumnName = "idcolaborador")
    private Colaborador colaborador;

}
