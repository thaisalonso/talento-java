package br.com.tpa.livrariaapi.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tpa.livrariaapi.model.Cliente;
import br.com.tpa.livrariaapi.service.ClientesService;

@RestController
@RequestMapping("clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;

	@PostMapping
	public Cliente incluir(@RequestBody Cliente cliente) {
		return clientesService.incluir(cliente);
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clientesService.listar();
	}
	
	@GetMapping(params = "codigo")
	public ResponseEntity<Cliente> buscar(@RequestParam("codigo") Long codigo) {
		Optional<Cliente> cliente = clientesService.buscar(codigo);
		if (cliente.isPresent()) {
			return ok(cliente.get());
		} else {
			return notFound().build();
		}
	}
	
	@DeleteMapping(params = "codigo")
	public ResponseEntity<Void> excluir(@RequestParam("codigo") Long codigo) {
		Optional<Cliente> cliente = clientesService.buscar(codigo);
		if (cliente.isPresent()) {
			clientesService.excluir(cliente.get());
			return noContent().build();
		} else {
			return notFound().build();
		}
	}
	
}
