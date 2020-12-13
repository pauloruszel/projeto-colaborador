package br.net.mirante.colaborador.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO implements BaseDTO {

    private Long id;
    private String numeroTelefone;
    private String descricaoEmail;
    private String nomeRedeSocial;
    private String nmTelefone;
    private ColaboradorDTO colaborador;
    private TipoContatoDTO tipoContato;
}
