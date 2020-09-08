package com.Farmacia.dez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Farmacia.dez.model.Categoria;
import com.Farmacia.dez.model.Produto;
import com.Farmacia.dez.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController<produtos> {

		@Autowired
		private ProdutoRepository repositoty;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> getAll;{
			return ResponseEntity.ok (repositoty.findAll());
		}
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> getById(@PathVariable long id){
			return repositoty.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Categoria>> getByName(@PathVariable String nome){
			return ResponseEntity.ok(repositoty.findAllByDescricaoIgnoreCase(nome));
		}
		@PostMapping
		public ResponseEntity<Object> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(produto));
		}
		@PutMapping
		public ResponseEntity<Object> put (@RequestBody Produto produto){
		return ResponseEntity.ok(repositoty.save(produto));
		}
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repositoty.deleteById(id);
		}
}
		

