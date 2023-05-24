package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ItemCardapioTabelaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;
    private boolean destaque;
    private boolean ativo;
    private List<String> categorias;
    private Long restauranteId;
    
}