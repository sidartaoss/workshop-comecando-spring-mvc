/**
 * 
 */
package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

/**
 * @author SEMPR
 *
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";

	@Autowired
	private Titulos titulos;
	
	@PersistenceContext
	private EntityManager manager;
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		if (titulo.getCodigo() == null) {
			Long last = this.buscarUltimoRegistro();
			titulo.setCodigo(++last);
		}
		this.titulos.save(titulo);
		attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping 
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	/** public ModelAndView edicao(@PathVariable Long codigo) { **/
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
			/** System.out.println(">>>> codigo recebido: " + codigo); **/
			
			/** Titulo titulo = titulos.findOne(codigo); **/
			
			/** ModelAndView mv = new ModelAndView("redirect:/titulos/novo"); **/
			ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
			mv.addObject(titulo);
			return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	public Long buscarUltimoRegistro() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Titulo> root = criteria.from(Titulo.class);
		criteria.select(builder.max(root.get("codigo")));
		return manager.createQuery(criteria).getSingleResult();
	}	
}
