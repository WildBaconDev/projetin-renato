package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoa> consultar(@PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = service.consultar(id);
		
		if (pessoa.isPresent()) {
			return ResponseEntity.ok( pessoa.get() );
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> lista() {
		return ResponseEntity.ok( service.listar() );
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {		
		return ResponseEntity.ok( service.salvar(pessoa) );
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) { 
		return ResponseEntity.ok( service.salvar(pessoa) );
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> remover( @PathVariable("id") Long id ) {
		Optional<Pessoa> pessoaEncontrada = service.consultar(id);
		
		if (pessoaEncontrada.isPresent()) {			
			service.remover(id);	
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
