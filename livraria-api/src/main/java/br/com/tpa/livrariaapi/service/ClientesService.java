package br.com.tpa.livrariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tpa.livrariaapi.model.Cliente;
import br.com.tpa.livrariaapi.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public Cliente incluir(Cliente cliente) {
		return clientesRepository.save(cliente);
	}
	
	public List<Cliente> listar() {
		return clientesRepository.findAll();
	}
	
	public Cliente buscar(Long codigo) {
		Cliente cliente = clientesRepository.findById(codigo).orElse(null);
		return cliente;
	}
	
	public void excluir(Cliente cliente) {
		clientesRepository.delete(cliente);
	}

}
