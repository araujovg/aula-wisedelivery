package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.RestauranteCategoria;

public interface RestauranteCategoriaRepository extends JpaRepository<RestauranteCategoria, Long>{
    
}