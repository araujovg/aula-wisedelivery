package br.com.gva.wisedelivery.dominio.entidades.pedido;

import java.math.BigDecimal;

import br.com.gva.wisedelivery.dominio.entidades.pedido.enums.ItemPedidoPK;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.ItemCardapio;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Getter @Setter
    @EmbeddedId
    private ItemPedidoPK id;
    
    @Getter @Setter
    @ManyToOne
    private ItemCardapio itemCardapio;

    @Getter @Setter
    private String observacoes;

    @Setter
    private BigDecimal preco;

    @Getter @Setter
    private int quantidade;

    public BigDecimal getPreco(){
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
}