package br.com.gva.wisedelivery.integracao.dados;

import lombok.Getter;

public enum StatusPagamento {
    
    AUTORIZADO("Autorizado"),
    NAO_AUTORIZADO("Não Autorizado"),
    CARTAO_INVALIDO("Cartão Inválido ou bloqueado");

    @Getter String descricao;

    StatusPagamento(String descricao) {
        this.descricao  = descricao;
    }
}