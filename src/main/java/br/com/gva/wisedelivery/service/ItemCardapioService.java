package br.com.gva.wisedelivery.service;

import java.util.List;
import java.util.Optional;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.gva.wisedelivery.dominio.restaurante.CategoriaItem;

public interface ItemCardapioService {

    ItemCardapioDTO salvar(ItemCardapioDTO dto);

    ItemCardapioDTO procurarPeloId(Long id);

    List<ItemCardapioDTO> procurarTodos();

    void deletar(Long id);

    List<CategoriaItem> pegarTodasAsCategorias();

}