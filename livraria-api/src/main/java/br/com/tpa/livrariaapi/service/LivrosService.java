package br.com.tpa.livrariaapi.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Livro> buscar(Long codigo) {
		Optional<Livro> livro = livrosRepository.findById(codigo);
		return livro;
	}
	
	public void excluir(Livro livro) {
		livrosRepository.delete(livro);
	}
	
	public List<Livro> buscarPorCodigos(List<Long> codigos) {
		return livrosRepository.buscarPorCodigos(codigos);
	}
	
	public List<Livro> buscarPorTitulo(String titulo) {
		return livrosRepository.buscarPorTitulo("%" + titulo + "%");
	}
	
	public List<Livro> buscarPorAutor(String autor) {
		return livrosRepository.buscarPorAutor("%" + autor + "%");
	}

}
