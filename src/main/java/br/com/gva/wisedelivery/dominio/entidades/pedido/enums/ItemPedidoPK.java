package br.com.gva.wisedelivery.dominio.entidades.pedido.enums;

import br.com.gva.wisedelivery.dominio.entidades.pedido.Pedido;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class ItemPedidoPK {
    
    @ManyToOne
    private Pedido pedido;

    private Integer ordem;
}