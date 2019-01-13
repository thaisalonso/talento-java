package br.com.tpa.livrariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tpa.livrariaapi.model.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long>{

}
