/**
 * 
 */
package com.algaworks.cobranca.model;

/**
 * @author SEMPR
 *
 */
public enum StatusTitulo {
	
	PENDENTE("Pendente"),
	RECEBIDO("Recebido");
	/** CANCELADO("Cancelado"); **/
	
	private String descricao;
	
	private StatusTitulo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
