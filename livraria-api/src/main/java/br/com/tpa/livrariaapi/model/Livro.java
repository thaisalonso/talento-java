package br.com.tpa.livrariaapi.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name = "Livro.buscarPorCodigos", query = "SELECT l FROM Livro l WHERE l.codigo IN :codigos"),
	@NamedQuery(name = "Livro.buscarPorTitulo", query = "SELECT l FROM Livro l WHERE UPPER(l.titulo) LIKE UPPER(:titulo)"),
	@NamedQuery(name = "Livro.buscarPorAutor", query = "SELECT l FROM Livro l WHERE UPPER(l.autor) LIKE UPPER(:autor)")
})
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String autor;

	@NotNull
	private BigDecimal valor;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
