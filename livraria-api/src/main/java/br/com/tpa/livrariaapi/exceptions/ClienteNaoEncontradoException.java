package br.com.tpa.livrariaapi.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8596742659491552515L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
