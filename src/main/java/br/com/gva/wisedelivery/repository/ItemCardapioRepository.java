package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.restaurante.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {
    
}