package com.tiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.domain.Livro;
import com.tiago.bookstore.repositories.LivroRepository;
import com.tiago.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id: " + id + " , Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro livro) {
		Livro newLivro = findById(id);
		updateData(newLivro, livro);
		return repository.save(newLivro);
	}

	private void updateData(Livro newLivro, Livro livro) {
		newLivro.setTitulo(livro.getTitulo());
		newLivro.setNome_autor(livro.getNome_autor());
		newLivro.setTexto(livro.getTexto());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}	
}
