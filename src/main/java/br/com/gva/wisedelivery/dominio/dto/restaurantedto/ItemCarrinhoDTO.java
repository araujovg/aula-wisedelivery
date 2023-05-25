package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemCarrinhoDTO {

    private ItemCardapioDTO itemCardapioDTO;
    private String observacoes;
    private BigDecimal preco;
    private int quantidade;

}
