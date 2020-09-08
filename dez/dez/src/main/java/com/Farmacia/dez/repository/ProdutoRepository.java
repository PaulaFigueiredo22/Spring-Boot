package com.Farmacia.dez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Farmacia.dez.model.Categoria;

public interface ProdutoRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria> findAllByDescricaoIgnoreCase(String descricao);
	
	

}
