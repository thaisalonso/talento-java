package br.com.tpa.livrariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tpa.livrariaapi.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	
	@Query(name = "Cliente.buscarPorNome")
	List<Cliente> buscarPorNome(@Param("nome") String nome);

	@Query(name = "Cliente.buscarPorCpf")
	List<Cliente> buscarPorCpf(@Param("cpf") String cpf);
}
