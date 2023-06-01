package br.com.gva.wisedelivery.dominio.entidades.pagamento.enums;

import lombok.Getter;

public enum TipoPagamento {

    DINHEIRO(1, "Dinheiro"),
    CARTAO(2, "Cartão de crédito"),
    PIX(3, "Pix");

    @Getter private int ordem;
    @Getter private String descricao;

    TipoPagamento(int ordem, String descricao) {
        this.ordem = ordem;
        this.descricao = descricao;
    }
    
}