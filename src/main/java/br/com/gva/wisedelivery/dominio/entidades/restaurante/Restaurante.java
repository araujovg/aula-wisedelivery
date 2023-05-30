package br.com.gva.wisedelivery.dominio.entidades.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import br.com.gva.wisedelivery.dominio.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "restaurante")
public class Restaurante extends Usuario {
    
    @Getter @Setter
    private String cnpj;

    @Getter @Setter
    private String logotipo;

    @Getter @Setter
    private BigDecimal taxaEntrega;

    @Getter @Setter
    private Integer tempoEntrega;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "restaurante_relacao_categorias",
        joinColumns = @JoinColumn(name = "restaurante_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id")
    )
    @ToString.Exclude
    private Set<RestauranteCategoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "restaurante")
    private Set<ItemCardapio> cardapio = new HashSet<>();
}