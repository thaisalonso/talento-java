package br.com.tpa.livrariaapi.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Cliente> buscar(Long codigo) {
		Optional<Cliente> cliente = clientesRepository.findById(codigo);
		return cliente;
	}
	
	public void excluir(Cliente cliente) {
		clientesRepository.delete(cliente);
	}

	public List<Cliente> buscarPorNome(String nome) {
		return clientesRepository.buscarPorNome("%" + nome + "%");
	}
	
	public List<Cliente> buscarPorCpf(String cpf) {
		return clientesRepository.buscarPorCpf(cpf);
	}
}
