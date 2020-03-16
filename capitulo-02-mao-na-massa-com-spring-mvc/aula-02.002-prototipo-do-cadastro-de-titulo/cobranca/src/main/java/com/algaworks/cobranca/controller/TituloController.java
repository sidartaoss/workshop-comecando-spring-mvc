/**
 * 
 */
package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SEMPR
 *
 */
@Controller
public class TituloController {

	@RequestMapping("/titulos/novo")
	public String novo() {
		return "CadastroTitulo";
	}
}
