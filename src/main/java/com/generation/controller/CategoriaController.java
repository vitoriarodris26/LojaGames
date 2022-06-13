package com.generation.controller;





import java.util.List;

import javax.validation.Valid;

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

import com.generation.model.Categoria;
import com.generation.model.Produto;
import com.generation.repository.CategoriaRepository;
import com.generation.repository.ProdutoRepository;

	@RestController
	@RequestMapping("/categorias")
	@CrossOrigin(origins="*", allowedHeaders= "*")
	public class CategoriaController {

		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@Autowired
		private CategoriaRepository categoriaRepository;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll() { 
			return ResponseEntity.ok(categoriaRepository.findAll());
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity <Categoria> GetById (@PathVariable long id) {
				return categoriaRepository.findById(id)
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
		}	
		@GetMapping ("/titulo/{titulo}")
		public ResponseEntity <List<Produto>> getByTitulo (@PathVariable String titulo) {
		return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(titulo));
		
		}
		@PostMapping
		public ResponseEntity<Categoria> postCategoria (@Valid @RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		}
		
		@PutMapping
		public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
		}

			
			@DeleteMapping ("/{id}")
			public ResponseEntity <Categoria> delete (@PathVariable Long id) {
				
				if (id == null || !categoriaRepository.existsById(id)) {
					return ResponseEntity.notFound().build(); 
				}
				
				produtoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
			}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
