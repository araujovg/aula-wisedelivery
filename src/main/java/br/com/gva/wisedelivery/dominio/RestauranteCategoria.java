package br.com.gva.wisedelivery.dominio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categoria_restaurante")
public class RestauranteCategoria {
    
    @Getter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String imagem;

    @Getter @Setter
    @ManyToMany(mappedBy = "categorias")
    private Set<Restaurante> restaurantes = new HashSet<>();
}