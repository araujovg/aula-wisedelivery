package br.com.gva.wisedelivery.dominio.entidades.restaurante;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemCardapio {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;
    private boolean destaque;
    private boolean ativo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "item_relacao_categoria",
        joinColumns = @JoinColumn(name = "itemId"),
        inverseJoinColumns = @JoinColumn(name = "categoriaItemId")
    )
    private List<CategoriaItem> categorias;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    
}