package br.com.tpa.livrariaapi.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tpa.livrariaapi.model.Livro;
import br.com.tpa.livrariaapi.service.LivrosService;

@RestController
@RequestMapping("livros")
public class LivrosController {
	
	@Autowired
	private LivrosService livrosService;
	
	@PostMapping
	public Livro incluir(@RequestBody Livro livro) {
		return livrosService.incluir(livro);
	}
	
	@GetMapping
	public List<Livro> listar() {
		return livrosService.listar();
	}
	
	@GetMapping(params = "codigo")
	public ResponseEntity<Livro> buscar(@RequestParam("codigo") Long codigo) {
		Livro livro = livrosService.buscar(codigo);
		if (livro == null) {
			return notFound().build();
		}
		return ok(livro);
	}
	
	@DeleteMapping(params = "codigo")
	public ResponseEntity<Void> excluir(@RequestParam("codigo") Long codigo) {
		Livro livro = livrosService.buscar(codigo);
		if (livro == null) {
			return notFound().build();
		}
		livrosService.excluir(livro);
		return noContent().build();
	}

}
