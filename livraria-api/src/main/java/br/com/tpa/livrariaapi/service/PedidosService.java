package br.com.tpa.livrariaapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tpa.livrariaapi.exceptions.ClienteNaoEncontradoException;
import br.com.tpa.livrariaapi.exceptions.LivroNaoEncontradoException;
import br.com.tpa.livrariaapi.model.Cliente;
import br.com.tpa.livrariaapi.model.Livro;
import br.com.tpa.livrariaapi.model.Pedido;
import br.com.tpa.livrariaapi.repository.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	@Autowired
	private LivrosService livrosService;
	
	@Autowired
	private ClientesService clientesService;

	public Pedido incluir(Pedido pedido) {
		Optional<Cliente> cliente = clientesService.buscar(pedido.getCliente().getCodigo());
		Cliente clienteRetornado = cliente.orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
		pedido.setCliente(clienteRetornado);
		
		List<Long> codigosLivros = pedido.getLivros().stream()
								   .map(Livro::getCodigo)
								   .collect(Collectors.toList());
		
		List<Livro> livros = livrosService.buscarPorCodigos(codigosLivros);
		if (livros.isEmpty()) {
			throw new LivroNaoEncontradoException("Livros não encontrados");
		}
		BigDecimal total = livros.stream()
				  .map(Livro::getValor)
				  .reduce(BigDecimal.ZERO, BigDecimal::add);
		Long quantidade = Long.valueOf(livros.size());
		pedido.setLivros(livros);
		pedido.setValor(total);
		pedido.setQuantidade(quantidade);
		pedido.setCadastro(LocalDate.now());
		return pedidosRepository.save(pedido);
	}
	
	public List<Pedido> listar() {
		return pedidosRepository.findAll();
	}
	
	public Optional<Pedido> buscar(Long codigo) {
		Optional<Pedido> pedido = pedidosRepository.findById(codigo);
		return pedido;
	}
	
	public void excluir(Pedido pedido) {
		pedidosRepository.delete(pedido);
	}
}
