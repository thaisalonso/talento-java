package br.com.tpa.livrariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tpa.livrariaapi.model.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
