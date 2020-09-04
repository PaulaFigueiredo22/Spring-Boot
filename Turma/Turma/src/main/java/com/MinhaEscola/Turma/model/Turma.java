package com.MinhaEscola.Turma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Spring;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name="Alunos")
public class Turma {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min=1, max=5)
	private Spring Turma;
	
	private boolean ativo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Spring getTurma() {
		return Turma;
	}

	public void setTurma(Spring turma) {
		this.Turma = turma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
