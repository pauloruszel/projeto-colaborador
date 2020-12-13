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
@AttributeOverride(name = "id", column = @Column(name = "idContato", unique = true, nullable = false, length = 4, precision = 10))
public class Contato extends BaseEntity {

    @Column(name = "dsContato", length = 80)
    private String descricaoContato;

    @OneToOne
    @JoinColumn(name = "idTipoContato", referencedColumnName = "idtipoContato")
    private TipoContato tipoContato;
}
