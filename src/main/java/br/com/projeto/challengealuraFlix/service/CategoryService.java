package br.com.projeto.challengealuraFlix.service;

import java.util.List;

import br.com.projeto.challengealuraFlix.entity.Category;

public interface CategoryService {
	
	public List<Category> findAll();

	public Category findById(Long id);

	public void save(Category video);

	public Category update(Category video, Category videoUpdate);

	public void deleteById(long id);

}
