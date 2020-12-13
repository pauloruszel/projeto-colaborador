package br.net.mirante.colaborador.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO implements BaseDTO {

    private Long id;
    private String nome;
    private String nomeCargo;
    private String nomeTime;
    private EnderecoDTO endereco;
    private List<ContatoDTO> contatos;

}
