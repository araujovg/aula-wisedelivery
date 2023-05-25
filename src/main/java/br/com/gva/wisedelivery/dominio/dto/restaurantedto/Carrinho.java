package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.dominio.restaurante.Restaurante;
import br.com.gva.wisedelivery.repository.RestauranteRepository;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import br.com.gva.wisedelivery.service.RestauranteService;
import lombok.Getter;
import lombok.Setter;

public class Carrinho {

    public Carrinho(
        RestauranteService restauranteService,
        ItemCardapioService itemCardapioService
    ) {
        this.restauranteService = restauranteService;
        this.itemCardapioService = itemCardapioService;
    }

    @Getter private final RestauranteService restauranteService;

    @Getter private final ItemCardapioService itemCardapioService;

    private List<ItemCarrinhoDTO> itens = new ArrayList<>();
    @Getter private Restaurante restaurante;
    @Getter private ItemCardapioDTO itemCardapioDTO;

    public void adicionarItem(ItemCarrinhoDTO itemCarrinho, Long itemCardapioId) {

        setItemCardapioDTO(itemCardapioId);

        if(itens.isEmpty()){
            this.restaurante = getItemCardapioDTO().getRestaurante();
        }
        else if(!restauranteDiferente(getItemCardapioDTO().getRestaurante())) {
            //criar e lancar excecao
        }

        if(existeItemIgual(getItemCardapioDTO())) {
            ItemCarrinhoDTO itemJaExistente =
        }
    }

    private boolean restauranteDiferente(Restaurante restaurante) {
        return this.restaurante.equals(restaurante);
    }

    private Restaurante pegaRestaurante(Long restauranteId) {
        return getRestauranteService().procurarRestaurante(restauranteId);
    }

    private void setItemCardapioDTO(Long itemCardapioId) {
        this.itemCardapioDTO = getItemCardapioService().procurarPeloId(itemCardapioId);
    }

    private boolean existeItemIgual(ItemCardapioDTO itemCardapio) {

        return itens.stream().anyMatch( item ->
            item.getItemCardapioDTO().getId().equals(itemCardapio.getId())
        );
    }

}
