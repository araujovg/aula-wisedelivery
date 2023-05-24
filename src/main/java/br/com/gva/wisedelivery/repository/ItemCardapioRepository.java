package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.dominio.restaurante.Restaurante;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


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