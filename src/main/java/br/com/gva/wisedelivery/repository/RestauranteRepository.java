package br.com.gva.wisedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.entidades.restaurante.Restaurante;
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

    Optional<Restaurante> findByEmail(String email);
    
}