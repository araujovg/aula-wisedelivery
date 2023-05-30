package br.com.gva.wisedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gva.wisedelivery.dominio.entidades.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;


public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    
    List<ItemCardapio> findByRestauranteAndAtivoOrderByNome(Restaurante restaurante, boolean ativo);

    List<ItemCardapio> findByRestauranteIdAndDestaqueAndAtivoOrderByNome(Long restauranteId, boolean destaque, boolean ativo);

    @Query("SELECT DISTINCT itemCardapio " +
            "FROM ItemCardapio itemCardapio " +
            "WHERE itemCardapio.restaurante.id = ?1 " +
            "AND itemCardapio.destaque = true " +
            "AND itemCardapio.ativo = true " +
            "ORDER BY itemCardapio.nome")
    List<ItemCardapio> procurarPeloIdDoRestauranteEDestaqueEAtivoEOrdenarPeloNome(Long restauranteId);
}