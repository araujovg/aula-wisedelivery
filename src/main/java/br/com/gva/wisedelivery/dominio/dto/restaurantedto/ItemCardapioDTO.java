package br.com.gva.wisedelivery.dominio.dto.restaurantedto;

import java.math.BigDecimal;
import java.util.List;

import br.com.gva.wisedelivery.dominio.entidades.restaurante.CategoriaItem;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
import lombok.Data;

@Data
public class ItemCardapioDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;
    private boolean destaque;
    private boolean ativo;
    private List<CategoriaItem> categorias;
    private Restaurante restaurante;
}