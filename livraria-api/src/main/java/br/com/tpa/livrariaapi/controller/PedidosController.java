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

import br.com.tpa.livrariaapi.model.Pedido;
import br.com.tpa.livrariaapi.service.PedidosService;

@RestController
@RequestMapping("pedidos")
public class PedidosController {
	
	@Autowired
	private PedidosService pedidosService;
	
	@PostMapping
	public Pedido incluir(@RequestBody Pedido pedido) {
		return pedidosService.incluir(pedido);
	}
	
	@GetMapping
	public List<Pedido> listar() {
		return pedidosService.listar();
	}

	@GetMapping(params = "codigo")
	public ResponseEntity<Pedido> buscar(@RequestParam("codigo") Long codigo) {
		Optional<Pedido> pedido = pedidosService.buscar(codigo);
		if (pedido.isPresent()) {
			return ok(pedido.get());
		} else {
			return notFound().build();
		}
		
	}
	
	@DeleteMapping(params = "codigo")
	public ResponseEntity<Void> excluir(@RequestParam("codigo") Long codigo) {
		Optional<Pedido> pedido = pedidosService.buscar(codigo);
		if (pedido.isPresent()) {
			pedidosService.excluir(pedido.get());
			return noContent().build();
		} else {
			return notFound().build();
		}
		
	}
}
