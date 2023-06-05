package br.com.gva.wisedelivery.dominio.dto.pedidodto;

import java.math.BigDecimal;

import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;
import br.com.gva.wisedelivery.dominio.dto.enderecodto.EnderecoDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;
import br.com.gva.wisedelivery.dominio.entidades.pedido.enums.Status;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PedidoDTO {

    private Restaurante restaurante;
    private ClienteSalvoDTO cliente;
    private Carrinho carrinho;
    private boolean pagamento;
    private EnderecoDTO endereco;
    private BigDecimal subTotal;
    private BigDecimal taxaEntrega;
    private BigDecimal total;
    private Status status;
    
}