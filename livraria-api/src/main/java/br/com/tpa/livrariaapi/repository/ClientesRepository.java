package br.com.tpa.livrariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tpa.livrariaapi.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

}
