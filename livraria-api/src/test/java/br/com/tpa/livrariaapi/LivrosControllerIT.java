package br.com.tpa.livrariaapi;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tpa.livrariaapi.controller.LivrosController;
import br.com.tpa.livrariaapi.model.Livro;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivrosControllerIT {

	@Autowired
	private LivrosController controller;
	private Livro livro1;
	private Livro livro2;
	
	@Before
	public void setUp() {
		livro1 = new Livro();
		livro1.setTitulo("O jogo dos tronos");
		livro1.setDescricao("Livro 1 da série As Crônicas de Gelo e Fogo");
		livro1.setAutor("George R. R. Martin");
		livro1.setValor(new BigDecimal(40.00));
		
		livro2 = new Livro();
		livro2.setTitulo("Deuses Americanos");
		livro2.setDescricao("Uma mistura de fantasia e várias vertentes da mitologia antiga e moderna");
		livro2.setAutor("Neil Gaiman");
		livro2.setValor(new BigDecimal(45.00));
	}
	
	@Test
	@Transactional
	public void incluir_quandoIncluirUmLivro_deveRetornarApenasUmLivro() {
		controller.incluir(livro1);
		List<Livro> livros = controller.listar();
		assertEquals(1, livros.size());
	}
	
	@Test
	@Transactional
	public void incluir_quandoIncluirDoisLivros_deveRetornarDoisLivros() {
		controller.incluir(livro1);
		controller.incluir(livro2);
		List<Livro> livros = controller.listar();
		assertEquals(2, livros.size());
	}
	
	@Test
	@Transactional
	public void buscar_quandoBuscarPorCodigo_deveRetornarLivro() {
		Livro livroIncluido = controller.incluir(livro1);
		Livro livroRetornado = controller.buscar(livroIncluido.getCodigo()).getBody();
		assertEquals(livroRetornado.getTitulo(), "O jogo dos tronos");
	}
	
	@Test
	@Transactional
	public void excluir_quandoExcluirLivro_deveRetornarListaVazia() {
		Livro livroIncluido = controller.incluir(livro1);
		controller.excluir(livroIncluido.getCodigo());
		List<Livro> livros = controller.listar();
		assertEquals(0, livros.size());
	}
}
