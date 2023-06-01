package br.com.gva.wisedelivery.dominio.dto.pedidodto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;
import br.com.gva.wisedelivery.dominio.dto.enderecodto.EnderecoDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;
import br.com.gva.wisedelivery.dominio.entidades.pedido.ItemPedido;
import lombok.Data;

@Data
public class PedidoTelaFinalizarDTO {

    private LocalDateTime data;
    private RestauranteSalvoDTO restaurante;
    private ClienteSalvoDTO cliente;
    private BigDecimal subTotal;
    private BigDecimal taxaEntrega;
    private BigDecimal total;
    private List<ItemPedido> itens;
    private EnderecoDTO endereco;

}