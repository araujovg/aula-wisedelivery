package br.com.gva.wisedelivery.integracao.dados;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class DadosCartao {

    @Getter @Setter
    @Pattern(regexp = "\\d{16}", message = "Número cartão inválido")
    private String numeroCartao;
}