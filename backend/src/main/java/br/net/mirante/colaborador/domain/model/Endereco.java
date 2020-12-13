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
@AttributeOverride(name = "id", column = @Column(name = "idEndereco", unique = true, nullable = false, length = 4, precision = 10))
public class Endereco extends BaseEntity {

    @Column(name = "dsEndereco", length = 100)
    private String decricaoEndereco;

}
