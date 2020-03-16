/**
 * 
 */
package com.algaworks.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.cobranca.model.Titulo;

/**
 * @author sosilva
 *
 */
public interface Titulos extends JpaRepository<Titulo, Long> {

}
