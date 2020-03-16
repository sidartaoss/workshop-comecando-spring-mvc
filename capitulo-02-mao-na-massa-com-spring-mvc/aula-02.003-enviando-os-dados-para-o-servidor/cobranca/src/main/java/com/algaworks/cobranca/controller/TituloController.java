/**
 * 
 */
package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.cobranca.model.Titulo;

/**
 * @author SEMPR
 *
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

//	@RequestMapping("/titulos/novo")
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
//	@RequestMapping(value = "/titulos", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
//	public void salvar() {
	public String salvar(Titulo titulo) {
		//TODO: Salvar no banco de dados
		
		System.out.println(">>>" + titulo.getDescricao());
		
		return "CadastroTitulo";
	}
}
