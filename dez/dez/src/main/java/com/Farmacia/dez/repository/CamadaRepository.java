package com.Farmacia.dez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Farmacia.dez.model.Categoria;

@Repository
public interface CamadaRepository extends JpaRepository<Categoria, Long> {
		public List<Categoria> findAllByDescricaoContainIgnoreCase(String descricao);
		
}
