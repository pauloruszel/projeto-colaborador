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
@AttributeOverride(name = "id", column = @Column(name = "idColaborador", unique = true, nullable = false, length = 4, precision = 10))
public class Colaborador extends BaseEntity {

    @Column(name = "nmColaborador", length = 50)
    private String nome;

    @Column(name = "nmCargo", length = 40)
    private String nomeCargo;

    @Column(name = "nmTime", length = 40)
    private String nomeTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "idendereco")
    private Endereco endereco;

}
