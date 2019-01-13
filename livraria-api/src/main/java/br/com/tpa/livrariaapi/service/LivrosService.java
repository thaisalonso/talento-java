package br.com.tpa.livrariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tpa.livrariaapi.model.Livro;
import br.com.tpa.livrariaapi.repository.LivrosRepository;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public Livro incluir(Livro livro) {
		return livrosRepository.save(livro);
	}
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long codigo) {
		Livro livro = livrosRepository.findById(codigo).orElse(null);
		return livro;
	}
	
	public void excluir(Livro livro) {
		livrosRepository.delete(livro);
	}

}
