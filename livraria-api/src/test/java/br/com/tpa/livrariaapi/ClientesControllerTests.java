package br.com.tpa.livrariaapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tpa.livrariaapi.controller.ClientesController;
import br.com.tpa.livrariaapi.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesControllerTests {
	
	@Autowired
	private ClientesController controller;
	private Cliente cliente1;
	private Cliente cliente2;
	
	@Before
	public void setUp() {
		cliente1 = new Cliente();
		cliente1.setNome("Ana");
		cliente1.setCpf("12345678909");
		
		cliente2 = new Cliente();
		cliente2.setNome("Renato");
		cliente2.setCpf("32145678909");
	}

	@Test
	@Transactional
	public void incluir_quandoIncluirUmCliente_deveRetornarApenasUmCliente() {
		controller.incluir(cliente1);
		List<Cliente> clientes = controller.listar();
		assertEquals(1, clientes.size());
	}
	
	@Test
	@Transactional
	public void incluir_quandoIncluirDoisClientes_deveRetornarDoisClientes() {
		controller.incluir(cliente1);
		controller.incluir(cliente2);
		List<Cliente> clientes = controller.listar();
		assertEquals(2, clientes.size());
	}
	
	@Test
	@Transactional
	public void buscar_quandoBuscarPorCodigo_deveRetornarCliente() {
		Cliente clienteIncluido = controller.incluir(cliente1);
		Cliente clienteRetornado = controller.buscar(clienteIncluido.getCodigo()).getBody();
		assertEquals(clienteRetornado.getNome(), "Ana");
	}
	
	@Test
	@Transactional
	public void excluir_quandoExcluirCliente_deveRetornarListaVazia() {
		Cliente clienteIncluido = controller.incluir(cliente1);
		controller.excluir(clienteIncluido.getCodigo());
		List<Cliente> clientes = controller.listar();
		assertEquals(0, clientes.size());
	}
}
