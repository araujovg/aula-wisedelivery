package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.gva.wisedelivery.dominio.restaurante.Restaurante;

import java.util.List;


public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    
    List<ItemCardapio> findByRestaurante(Restaurante restaurante);
}