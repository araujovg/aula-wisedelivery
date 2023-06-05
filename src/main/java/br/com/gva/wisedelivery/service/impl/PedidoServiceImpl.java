package br.com.gva.wisedelivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoDTO;
import br.com.gva.wisedelivery.dominio.dto.pedidodto.PedidoFecharDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.Carrinho;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCarrinhoDTO;
import br.com.gva.wisedelivery.dominio.entidades.cliente.Cliente;
import br.com.gva.wisedelivery.dominio.entidades.pedido.ItemPedido;
import br.com.gva.wisedelivery.exception.ObjetoNaoEncontradoException;
import br.com.gva.wisedelivery.repository.ClienteRepository;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.repository.PedidoRepository;
import br.com.gva.wisedelivery.service.ClienteService;
import br.com.gva.wisedelivery.service.PedidoService;
import br.com.gva.wisedelivery.service.RestauranteService;
import lombok.Getter;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    @Getter private RestauranteService restauranteService;

    @Autowired
    @Getter private ClienteService clienteService;

    @Autowired
    @Getter private ClienteRepository clienteRepository;

    @Autowired
    @Getter private ItemCardapioRepository itemCardapioRepository;

    @Autowired
    @Getter private PedidoRepository pedidoRepository;

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
    public PedidoDTO deCarrinhoParaPedidoDTO(Carrinho carrinho) {
        PedidoDTO pedido = PedidoDTO.builder()
            .carrinho(carrinho)
            .pagamento(false)
            .endereco(null)
            .subTotal(carrinho.getTotal())
            .taxaEntrega(carrinho.getRestaurante().getTaxaEntrega())
            .total(carrinho.getTotal().add(carrinho.getRestaurante().getTaxaEntrega()))
            .build();
        return pedido;
    }

    @Override
    public PedidoFecharDTO deCarrinhoParaPedidoFecharDto(Carrinho carrinho) {
        PedidoFecharDTO pedido = new PedidoFecharDTO();
        pedido.setRestaurante(getRestauranteService().procurarPeloEmail(carrinho.getRestaurante().getEmail()));
        pedido.setCliente(getClienteService().procurarPeloId(carrinho.getCliente().getId()));
        pedido.setSubTotal(carrinho.getTotal());
        pedido.setTaxaEntrega(carrinho.getRestaurante().getTaxaEntrega());
        pedido.setTotal(pedido.getSubTotal().add(pedido.getTaxaEntrega()));
        pedido.setItens(getItensPedido(carrinho.getItens()));
        return pedido;
    }


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

    /* @Override
    public PedidoDTO fecharPedido(PedidoFecharDTO pedido) {

        throw new UnsupportedOperationException("Unimplemented method 'fecharPedido'");
    } */

/*     @Override
    public PedidoFechadoDTO salvar(Carrinho carrinho) {

        Cliente cliente = getCLiente(carrinho.getCliente().getId());
        Pedido pedido = Pedido.builder()
            .cliente(cliente)
            .restaurante(carrinho.getRestaurante())
            .itens(getItensPedido(carrinho.getItens()))
            .subtotal(carrinho.getTotal())
            .taxaEntrega(carrinho.
            getRestaurante().getTaxaEntrega())
            .total(carrinho.getTotal().multiply(carrinho.getRestaurante().getTaxaEntrega()))
            .endereco(cliente.getEndereco())
            .build();

        return getPedidoRepository().save(pedido);
    } */

    public Cliente getCLiente(Long id){
        return getClienteRepository().findById(id).orElseThrow( () -> new ObjetoNaoEncontradoException(null));
    }

    @Override
    public void fecharPedido(Carrinho carrinho) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharPedido'");
    }
}