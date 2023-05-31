package br.com.gva.wisedelivery.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoTelaFinalizarDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCarrinhoDTO;
import br.com.gva.wisedelivery.dominio.entidades.pedido.ItemPedido;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import br.com.gva.wisedelivery.service.PedidoService;
import br.com.gva.wisedelivery.service.RestauranteService;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

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
        PedidoTelaFinalizarDTO pedido = new PedidoTelaFinalizarDTO();
        pedido.setData(LocalDateTime.now());
        pedido.setRestaurante(restauranteService.procurarPeloEmail(carrinho.getRestaurante().getEmail()));
        pedido.setSubtotal(carrinho.getTotal());
        pedido.setTaxaEntrega(carrinho.getRestaurante().getTaxaEntrega());
        pedido.setTotal(pedido.getSubtotal().add(pedido.getTaxaEntrega()));
        pedido.setItens(getItensPedido(carrinho.getItens()));
        return pedido;
    }

    @Override
    public PedidoDTO finalizarPedido(PedidoFinalizarDTO pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarPedido'");
    }

    private List<ItemPedido> getItensPedido(List<ItemCarrinhoDTO> itens){
        return itens.stream().map(item -> {
            return ItemPedido.builder()
                .itemCardapio(itemCardapioRepository.findById(item.getItemCardapio().getId()).get())
                .build();
        }).toList();
    }

}