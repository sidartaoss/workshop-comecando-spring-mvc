/**
 * 
 */
package com.algaworks.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import com.algaworks.cobranca.repository.filter.TituloFilter;

/**
 * @author SEMPR
 *
 */
@Service
public class CadastroTituloService {
	
	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
			this.titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data invalido.");
		}
	}

	public void excluir(Long codigo) {
		this.titulos.delete(codigo);
	}

	/** public void receber(Long codigo) { **/
	public String receber(Long codigo) {
		Titulo titulo = this.titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		this.titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return this.titulos.findByDescricaoContaining(descricao);
	}

}
