package br.com.gva.wisedelivery.service;

import java.util.List;

import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFechadoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFecharDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoTelaFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;

public interface PedidoService {

    PedidoDTO buscarPedidoPeloId(Long id);

    List<PedidoDTO> buscarTodosOsPedidosPorRestauranteId(Long restauranteId);

    List<PedidoDTO> buscarTodosOsPedidosPorClienteId(Long clienteId);

    PedidoTelaFinalizarDTO deCarrinhoParaPedido(Carrinho carrinho);

    PedidoFecharDTO deCarrinhoParaPedidoFecharDto(Carrinho carrinho);

    PedidoDTO fecharPedido(PedidoFecharDTO pedido);

    PedidoFechadoDTO salvar(Carrinho carrinho);

}
