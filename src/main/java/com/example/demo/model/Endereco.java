package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String numero;
	
	@Column(name = "PESSOA_ID")
	private Long idPessoa;
}
