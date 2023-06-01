package br.com.gva.wisedelivery.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import br.com.gva.wisedelivery.service.PedidoService;
import br.com.gva.wisedelivery.service.RestauranteService;
import lombok.Getter;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    @Getter private RestauranteService restauranteService;

    @Autowired
    @Getter private ItemCardapioRepository itemCardapioRepository;

    @Override
    public PedidoDTO buscarPedidoPeloId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPeloId'");
    }

    @Override
    public List<PedidoDTO> buscarTodosOsPedidosPorRestauranteId(Long restauranteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosOsPedidosPorRestauranteId'");
    }

    @Override
    public List<PedidoDTO> buscarTodosOsPedidosPorClienteId(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosOsPedidosPorClienteId'");
    }

    @Override
    public PedidoTelaFinalizarDTO deCarrinhoParaPedido(Carrinho carrinho) {
        PedidoTelaFinalizarDTO pedido = new PedidoTelaFinalizarDTO();
        pedido.setData(LocalDateTime.now());
        pedido.setRestaurante(getRestauranteService().procurarPeloEmail(carrinho.getRestaurante().getEmail()));
        pedido.setSubTotal(carrinho.getTotal());
        pedido.setTaxaEntrega(carrinho.getRestaurante().getTaxaEntrega());
        pedido.setTotal(pedido.getSubTotal().add(pedido.getTaxaEntrega()));
        pedido.setItens(getItensPedido(carrinho.getItens()));
        return pedido;
    }

    @Override
    public PedidoDTO finalizarPedido(PedidoFinalizarDTO pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarPedido'");
    }

    /* private List<ItemPedido> getItensPedido(List<ItemCarrinhoDTO> itens){
        ItemPedido itemPedido = new ItemPedido();
        List<ItemPedido> itensPedidoLista = new ArrayList<>();
        for(ItemCarrinhoDTO item : itens) {
            itemPedido.setObservacoes(item.getObservacoes());
            itemPedido.setPreco(item.getPreco());
            itemPedido.setQuantidade(item.getQuantidade());
            itemPedido.setItemCardapio(itemCardapioRepository.findById(item.getItemCardapio().getId()).get());
            itensPedidoLista.add(itemPedido);
        }
        return itensPedidoLista;
    } */

    private List<ItemPedido> getItensPedido(List<ItemCarrinhoDTO> itens){
        return itens.stream().map(item -> {
            return ItemPedido.builder()
                .observacoes(item.getObservacoes())
                .preco(item.getPreco())
                .quantidade(item.getQuantidade())
                .itemCardapio(itemCardapioRepository.findById(item.getItemCardapio().getId()).get())
                .build();
        }).toList();
    }
    
}