package br.com.gva.wisedelivery.dominio.dto.pedidodto;

import java.math.BigDecimal;

import br.com.gva.wisedelivery.dominio.dto.enderecodto.EnderecoDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PedidoDTO {

    private Carrinho carrinho;
    private boolean pagamento;
    private EnderecoDTO endereco;
    private BigDecimal subTotal;
    private BigDecimal taxaEntrega;
    private BigDecimal total;
}