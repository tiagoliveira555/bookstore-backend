package com.tiago.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.bookstore.domain.Livro;
import com.tiago.bookstore.repositories.LivroRepository;
import com.tiago.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id: " + id + " , Tipo: " + Livro.class.getName()));
	}
	
}
