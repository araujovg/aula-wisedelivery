package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gva.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
import br.com.gva.wisedelivery.exception.RestauranteDiferenteExcpetion;
import br.com.gva.wisedelivery.service.ClienteService;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Carrinho {

    public Carrinho(
        ItemCardapioService itemCardapioService,
        ClienteService clienteService
    ) {
        this.itemCardapioService = itemCardapioService;
        this.clienteService = clienteService;
    }

    private final ClienteService clienteService;
    private final ItemCardapioService itemCardapioService;

    @Getter private List<ItemCarrinhoDTO> itens = new ArrayList<>();
    @Getter private Restaurante restaurante;
    @Getter private ClienteSalvoDTO cliente;
    private ItemCardapioDTO itemCardapioDto;
    @Getter private BigDecimal total = new BigDecimal(0);

    public void adicionarItem(ItemCarrinhoDTO itemCarrinhoDTO, Long itemCardapioDtoId) {
        setItemCardapio(itemCardapioDtoId);
        log.info(String.format("Restaurante: [%s]", itemCardapioDto.getRestaurante().getNome()));
        if(itens.isEmpty()) {
            this.restaurante = itemCardapioDto.getRestaurante();
            itemCarrinhoDTO.setId(1L);
            
            setCliente(itemCarrinhoDTO.getClienteId());
        }
        else if(!restauranteIgual(itemCardapioDto.getRestaurante())) {
            throw new RestauranteDiferenteExcpetion("Não é possível adicionar itens de restaurantes diferentes no mesmo carrinho");
        }
        itemCarrinhoDTO.setItemCardapio(itemCardapioDto);
        itemCarrinhoDTO.setPreco(
            itemCardapioDto
                .getPreco()
                .multiply(BigDecimal.valueOf(itemCarrinhoDTO.getQuantidade()))
        );
        log.info(String.format("Adionando Item ao Carrinho: [%s]", itemCarrinhoDTO.getItemCardapio().getNome()));
        log.info(String.format("Adionando Item ao Carrinho. Preço: [%s]", itemCarrinhoDTO.getPreco()));
        log.info(String.format("Restaurante: [%s]", itemCarrinhoDTO.getItemCardapio().getRestaurante().getNome()));
        itemCarrinhoDTO.setId(itemCarrinhoDTO.getId().equals(1L) ? 1L : Long.valueOf(this.itens.size() + 1));
        itens.add(itemCarrinhoDTO);
        setTotalCarrinho(itens);
    }

    private boolean restauranteIgual(Restaurante restaurante) {
        return this.restaurante.equals(restaurante);
    }

    public void setItemCardapio(Long itemCardapioDtoId) {
        this.itemCardapioDto = itemCardapioService.procurarPeloId(itemCardapioDtoId);
    }

    public void removerItemDCarrinho(Long itemCarrinhoId){
        ItemCarrinhoDTO itemCarrinho = this.itens.stream().filter( item -> item.getId().equals(itemCarrinhoId)).toList().get(0);
        this.itens.remove(itemCarrinho);
        setTotalCarrinho(itens);
    }

    private void setTotalCarrinho(List<ItemCarrinhoDTO> itensCarrinho){
        setTotal(BigDecimal.ZERO);
        for(ItemCarrinhoDTO item : itensCarrinho) {
            setTotal(total.add(item.getPreco()));
        }
    }

    private void setTotal(BigDecimal valor){
        this.total = valor;
    }

    private void setCliente(Long clienteId){
        this.cliente = clienteService.procurarPeloId(clienteId);
    }

}