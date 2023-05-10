package br.com.gva.wisedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gva.wisedelivery.dominio.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

    Optional<Restaurante> findByEmail(String email);
    
}