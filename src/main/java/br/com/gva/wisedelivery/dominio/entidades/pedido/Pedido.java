package br.com.gva.wisedelivery.dominio.entidades.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gva.wisedelivery.dominio.entidades.cliente.Cliente;
import br.com.gva.wisedelivery.dominio.entidades.pedido.enums.Status;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDateTime data;
    private Status status;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Restaurante restaurante;
    private BigDecimal subtotal;
    private BigDecimal taxaEntrega;
    private BigDecimal total;
    private String endereco;

    @OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
    private List<ItemPedido> itens;

    public String getDiaPedido(){
        return String.valueOf(data.getDayOfMonth());
    }

    public String getMesPedido() {
        return String.valueOf(data.getMonth());
    }
}