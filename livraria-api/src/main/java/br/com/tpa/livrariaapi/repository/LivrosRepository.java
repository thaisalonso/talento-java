package br.com.tpa.livrariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tpa.livrariaapi.model.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
	
	@Query(name = "Livro.buscarPorCodigos")
	List<Livro> buscarPorCodigos(@Param("codigos") List<Long> codigos);
	
	@Query(name = "Livro.buscarPorTitulo")
	List<Livro> buscarPorTitulo(@Param("titulo") String titulo);

	@Query(name = "Livro.buscarPorAutor")
	List<Livro> buscarPorAutor(@Param("autor") String autor);
}
