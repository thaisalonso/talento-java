package br.com.tpa.livrariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tpa.livrariaapi.model.Pedido;
import br.com.tpa.livrariaapi.repository.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
	private PedidosRepository pedidosRepository;

	public Pedido incluir(Pedido pedido) {
		return pedidosRepository.save(pedido);
	}
	
	public List<Pedido> listar() {
		return pedidosRepository.findAll();
	}
	
	public Pedido buscar(Long codigo) {
		Pedido pedido = pedidosRepository.findById(codigo).orElse(null);
		return pedido;
	}
	
	public void excluir(Pedido pedido) {
		pedidosRepository.delete(pedido);
	}
}
