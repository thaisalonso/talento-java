package br.com.tpa.livrariaapi.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Livro> buscar(@PathVariable("codigo") Long codigo) {
		Optional<Livro> livro = livrosService.buscar(codigo);
		if (livro.isPresent()) {
			return ok(livro.get());
		} else {
			return notFound().build();
		}
		
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable("codigo") Long codigo) {
		Optional<Livro> livro = livrosService.buscar(codigo);
		if (livro.isPresent()) {
			livrosService.excluir(livro.get());
			return noContent().build();
		} else {
			return notFound().build();
		}
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Livro> atualizar(@PathVariable("codigo") Long codigo, @Valid @RequestBody Livro livro) {
		Optional<Livro> livroBuscado = livrosService.buscar(codigo);
		if (!livroBuscado.isPresent()) {
			return noContent().build();
		} 
		Livro livroExistente = livroBuscado.get();
		BeanUtils.copyProperties(livro, livroExistente, "codigo");
		livroExistente = livrosService.incluir(livroExistente);
		return ok(livroExistente);
	}
		
}
