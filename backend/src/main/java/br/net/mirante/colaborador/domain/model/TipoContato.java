package br.net.mirante.colaborador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@AttributeOverride(name = "id", column = @Column(name = "idTipoContato", unique = true, nullable = false, length = 4, precision = 10))
public class TipoContato extends BaseEntity {

    @Column(name = "nmTipoContato", length = 60)
    private String nomeTipoContato;

}
