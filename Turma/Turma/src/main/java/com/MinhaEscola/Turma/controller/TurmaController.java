package com.MinhaEscola.Turma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MinhaEscola.Turma.model.Turma;
import com.MinhaEscola.Turma.repository.TurmaRepository;

@RestController
@RequestMapping ("/turma")
@CrossOrigin ("*")
public class TurmaController {

		@Autowired
		private TurmaRepository repositoty;
		
		@GetMapping
		public ResponseEntity<Object> GetAll() {
			return ResponseEntity.ok(repositoty.findAll());
		}
		
		@GetMapping ("/{id}")
		
		public ResponseEntity <Turma> GetById(@PathVariable long id){
			return repositoty.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
			
		}
		
		@GetMapping ("/titulo/{titulo}")
		public ResponseEntity<List<Turma>> GetByTitulo(@PathVariable String turma){
			return ResponseEntity.ok(repositoty.findAllByTurmaContainigIgnoreCase(turma));
			
		}
		
		@PostMapping
		public ResponseEntity<Turma> postTurma (@RequestBody Turma turma){
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(turma));
			
		}
		@PutMapping
		public ResponseEntity<Turma> putTurma (@RequestBody Turma turma){
			return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(turma));
	}
}