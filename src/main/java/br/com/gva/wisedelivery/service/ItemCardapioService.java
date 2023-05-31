package br.com.gva.wisedelivery.service;

import java.util.List;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioTabelaDTO;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.CategoriaItem;

public interface ItemCardapioService {

    ItemCardapioDTO salvar(ItemCardapioDTO dto);

    ItemCardapioDTO procurarPeloId(Long id);

    List<ItemCardapioDTO> procurarTodos();

    void deletar(Long id);

    List<CategoriaItem> pegarTodasAsCategorias();

    List<ItemCardapioTabelaDTO> procurarTodosOsItensPeloIdDoRestaurante(Long id);

    List<ItemCardapioTabelaDTO> procurarTodosOsItensPeloIdDoRestauranteEQueEstejamEmDestaque(Long restauranteId);

}