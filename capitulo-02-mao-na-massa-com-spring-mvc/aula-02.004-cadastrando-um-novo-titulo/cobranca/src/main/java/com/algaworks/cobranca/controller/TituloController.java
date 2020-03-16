/**
 * 
 */
package com.algaworks.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

/**
 * @author SEMPR
 *
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Titulo titulo) {
		// TODO: Salvar no banco de dados

		// System.out.println(">>>" + titulo.getDescricao());
		
		this.titulos.save(titulo);

		return "CadastroTitulo";
	}
}
