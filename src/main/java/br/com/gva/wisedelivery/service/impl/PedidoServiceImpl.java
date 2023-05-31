package br.com.gva.wisedelivery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoTelaFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;
import br.com.gva.wisedelivery.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Override
    public PedidoDTO buscarPedidoPeloId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPeloId'");
    }

    @Override
    public List<PedidoDTO> buscarTodosPedidosPorRestauranteId(Long restauranteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosPedidosPorRestauranteId'");
    }

    @Override
    public List<PedidoDTO> buscarTodosPedidosPorClienteId(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosPedidosPorClienteId'");
    }

    @Override
    public PedidoTelaFinalizarDTO telaFinalizarPedido(Carrinho carrinho) {
        
        return null;
    }

    @Override
    public PedidoDTO finalizarPedido(PedidoFinalizarDTO pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarPedido'");
    }
    
}