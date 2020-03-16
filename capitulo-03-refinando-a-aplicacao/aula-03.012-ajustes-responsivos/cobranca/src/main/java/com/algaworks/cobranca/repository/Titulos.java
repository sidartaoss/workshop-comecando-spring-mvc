/**
 * 
 */
package com.algaworks.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.cobranca.model.Titulo;

/**
 * @author sosilva
 *
 */
public interface Titulos extends JpaRepository<Titulo, Long> {

	List<Titulo> findByDescricaoContaining(String descricao);
}
