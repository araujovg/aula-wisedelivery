package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.dominio.entidades.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}