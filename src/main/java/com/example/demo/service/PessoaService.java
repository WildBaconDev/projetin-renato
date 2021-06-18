package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> listar() {
		System.out.println("aqui");
		return repository.findAll();
	}

	public Optional<Pessoa> consultar(Long id) {
		return repository.findById(id);
	}

	
	@Transactional(value = TxType.REQUIRED)
	public Pessoa salvar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	@Transactional(value = TxType.REQUIRED)
	public void remover(Long id) {
		repository.deleteById(id);
	}
}