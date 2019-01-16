package br.com.tpa.livrariaapi.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1697605055327772897L;
	
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
