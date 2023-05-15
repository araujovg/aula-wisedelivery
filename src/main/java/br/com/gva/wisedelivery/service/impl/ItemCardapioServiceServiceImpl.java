package br.com.gva.wisedelivery.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.gva.wisedelivery.dominio.restaurante.CategoriaItem;
import br.com.gva.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.exception.ObjetoNaoEncontradoException;
import br.com.gva.wisedelivery.repository.CategoriaItemRepository;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.service.ItemCardapioService;
import lombok.Getter;

@Service
public class ItemCardapioServiceServiceImpl implements ItemCardapioService {

    @Autowired @Getter
    private ItemCardapioRepository itemCardapioRepository;

    @Autowired @Getter
    private CategoriaItemRepository categoriaItemRepository;

    @Override
    public ItemCardapioDTO salvar(ItemCardapioDTO dto) {
        ItemCardapio itemCardapio = getItemCardapioRepository().save(deDtoParaItemCardapio(dto));
        dto = deItemCardapioParaItemCardapioDTO(itemCardapio);
        return dto;
    }

    @Override
    public ItemCardapioDTO procurarPeloId(Long id) {
        ItemCardapio item = getItemCardapioRepository().findById(id).orElseThrow( ()-> new ObjetoNaoEncontradoException("Não foi encontrado nenhum item para o ID: " + id));
        return deItemCardapioParaItemCardapioDTO(item);
    }

    @Override
    public List<ItemCardapioDTO> procurarTodos() {
        return getItemCardapioRepository().findAll().stream().map(item -> deItemCardapioParaItemCardapioDTO(item)).toList();
    }

    @Override
    public void deletar(Long id) {
        getItemCardapioRepository().deleteById(id);
    }

    @Override
    public List<CategoriaItem> pegarTodasAsCategorias() {
        return getCategoriaItemRepository().findAll();
    }

    private ItemCardapio deDtoParaItemCardapio(ItemCardapioDTO dto){
        ItemCardapio itemCardapio = new ItemCardapio();
        BeanUtils.copyProperties(dto, itemCardapio);
        return itemCardapio;
    }

    private ItemCardapioDTO deItemCardapioParaItemCardapioDTO(ItemCardapio itemCardapio){
        ItemCardapioDTO dto = new ItemCardapioDTO();
        BeanUtils.copyProperties(itemCardapio, dto);
        return dto;
    }
    
}