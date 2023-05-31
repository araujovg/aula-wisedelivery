package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.entidades.restaurante.CategoriaItem;

public interface CategoriaItemRepository extends JpaRepository<CategoriaItem, Long> {
    
}