package br.com.gva.wisedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Optional<Cliente> findByEmail(String email);
}