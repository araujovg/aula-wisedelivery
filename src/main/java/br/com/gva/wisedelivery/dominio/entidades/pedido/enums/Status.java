package br.com.gva.wisedelivery.dominio.entidades.pedido.enums;

import lombok.Getter;

public enum Status {

    Producao(1, "Em produção", false),
    Entrega(2, "Saiu para entrega", false),
    Concluido(3, "Concluído", true);

    Status(int ordem, String descricao, boolean ultimo) {
        this.ordem = ordem;
        this.descricao = descricao;
        this.ultimo = ultimo;
    }
    
    @Getter int ordem;
    @Getter String descricao;
    @Getter boolean ultimo;
}