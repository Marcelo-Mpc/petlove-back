package br.com.petlove.exception;

public class Autenticacao extends RuntimeException{

	public Autenticacao(String msg) {
		super(msg);
	}
	
	public Autenticacao(String msg,Throwable cause ) {
		super(msg,cause);
	}
}
