package br.com.tpa.livrariaapi;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tpa.livrariaapi.controller.ClientesController;
import br.com.tpa.livrariaapi.controller.LivrosController;
import br.com.tpa.livrariaapi.controller.PedidosController;
import br.com.tpa.livrariaapi.model.Cliente;
import br.com.tpa.livrariaapi.model.Livro;
import br.com.tpa.livrariaapi.model.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidosControllerIT {

	@Autowired
	private PedidosController pedidosController;
	
	@Autowired
	private ClientesController clientesController;
	
	@Autowired
	private LivrosController livrosController;
	
	@Test
	@Transactional
	public void incluir_quandoIncluirUmPedido_deveRetornarApenasUmPedido() {
		
		Livro livro1 = new Livro();
		livro1.setTitulo("O jogo dos tronos");
		livro1.setDescricao("Livro 1 da série As Crônicas de Gelo e Fogo");
		livro1.setAutor("George R. R. Martin");
		livro1.setValor(new BigDecimal(40.00));
		
		Livro livro2 = new Livro();
		livro2.setTitulo("Deuses Americanos");
		livro2.setDescricao("Uma mistura de fantasia e várias vertentes da mitologia antiga e moderna");
		livro2.setAutor("Neil Gaiman");
		livro2.setValor(new BigDecimal(45.00));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Ana");
		cliente.setCpf("12345678909");
		
		clientesController.incluir(cliente);
		livrosController.incluir(livro1);
		livrosController.incluir(livro2);
		
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		livros.add(livro2);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setCadastro(LocalDate.now());
		pedido.setQuantidade(2L);
		pedido.setValor(livro1.getValor().add(livro2.getValor()));
		pedido.setLivros(livros);
		
		pedidosController.incluir(pedido);
		List<Pedido> pedidos = pedidosController.listar();
		
		assertEquals(1, pedidos.size());
	}
	
	@Test
	@Transactional
	public void incluir_quandoIncluirDoisPedidos_deveRetornarDoisPedidos() {
		
		Livro livro1 = new Livro();
		livro1.setTitulo("O jogo dos tronos");
		livro1.setDescricao("Livro 1 da série As Crônicas de Gelo e Fogo");
		livro1.setAutor("George R. R. Martin");
		livro1.setValor(new BigDecimal(40.00));
		
		Livro livro2 = new Livro();
		livro2.setTitulo("Deuses Americanos");
		livro2.setDescricao("Uma mistura de fantasia e várias vertentes da mitologia antiga e moderna");
		livro2.setAutor("Neil Gaiman");
		livro2.setValor(new BigDecimal(45.00));
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Ana");
		cliente1.setCpf("12345678909");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Elvis");
		cliente2.setCpf("32145678909");
		
		clientesController.incluir(cliente1);
		clientesController.incluir(cliente2);
		livrosController.incluir(livro1);
		livrosController.incluir(livro2);
		
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		livros.add(livro2);
		
		Pedido pedido1 = new Pedido();
		pedido1.setCliente(cliente1);
		pedido1.setCadastro(LocalDate.now());
		pedido1.setQuantidade(2L);
		pedido1.setValor(livro1.getValor().add(livro2.getValor()));
		pedido1.setLivros(livros);
		
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente2);
		pedido2.setCadastro(LocalDate.now());
		pedido2.setQuantidade(2L);
		pedido2.setValor(livro1.getValor().add(livro2.getValor()));
		pedido2.setLivros(livros);
		
		pedidosController.incluir(pedido1);
		pedidosController.incluir(pedido2);
		
		List<Pedido> pedidos = pedidosController.listar();
		
		assertEquals(2, pedidos.size());
	}
	
	@Test
	@Transactional
	public void buscar_quandoBuscarPorCodigo_deveRetornarPedido() {
		
		Livro livro1 = new Livro();
		livro1.setTitulo("O jogo dos tronos");
		livro1.setDescricao("Livro 1 da série As Crônicas de Gelo e Fogo");
		livro1.setAutor("George R. R. Martin");
		livro1.setValor(new BigDecimal(40.00));
		
		Livro livro2 = new Livro();
		livro2.setTitulo("Deuses Americanos");
		livro2.setDescricao("Uma mistura de fantasia e várias vertentes da mitologia antiga e moderna");
		livro2.setAutor("Neil Gaiman");
		livro2.setValor(new BigDecimal(45.00));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Ana");
		cliente.setCpf("12345678909");
		
		clientesController.incluir(cliente);
		livrosController.incluir(livro1);
		livrosController.incluir(livro2);
		
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		livros.add(livro2);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setCadastro(LocalDate.now());
		pedido.setQuantidade(2L);
		pedido.setValor(livro1.getValor().add(livro2.getValor()));
		pedido.setLivros(livros);
		
		pedidosController.incluir(pedido);
		Pedido pedidoRetornado = pedidosController.buscar(1L).getBody();
		
		assertEquals(pedidoRetornado.getCliente().getNome(), "Ana");
	}
	
}
