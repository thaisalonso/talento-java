package br.com.tpa.livrariaapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tpa.livrariaapi.controller.ClientesController;
import br.com.tpa.livrariaapi.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesControllerIT {
	
	@Autowired
	private ClientesController controller;

	@Test
	@Transactional
	public void incluir_quandoIncluirUmCliente_deveRetornarApenasUmCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Ana");
		cliente.setCpf("12345678909");
		
		controller.incluir(cliente);
		List<Cliente> clientes = controller.listar();
		
		assertEquals(1, clientes.size());
	}
	
	@Test
	@Transactional
	public void incluir_quandoIncluirDoisClientes_deveRetornarDoisClientes() {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Ana");
		cliente1.setCpf("12345678909");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Renato");
		cliente2.setCpf("32145678909");
		
		controller.incluir(cliente1);
		controller.incluir(cliente2);
		List<Cliente> clientes = controller.listar();
		
		assertEquals(2, clientes.size());
	}
}