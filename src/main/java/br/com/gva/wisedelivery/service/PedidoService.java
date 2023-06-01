package br.com.gva.wisedelivery.service;

import java.util.List;

import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoTelaFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;

public interface PedidoService {

    PedidoDTO buscarPedidoPeloId(Long id);

    List<PedidoDTO> buscarTodosOsPedidosPorRestauranteId(Long restauranteId);

    List<PedidoDTO> buscarTodosOsPedidosPorClienteId(Long clienteId);

    PedidoTelaFinalizarDTO deCarrinhoParaPedido(Carrinho carrinho);

    PedidoDTO finalizarPedido(PedidoFinalizarDTO pedido);
    
}