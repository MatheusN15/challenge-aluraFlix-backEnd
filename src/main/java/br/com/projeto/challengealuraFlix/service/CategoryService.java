package br.com.projeto.challengealuraFlix.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.projeto.challengealuraFlix.entity.Category;

public interface CategoryService {
	
	public Page<Category> findAll(Pageable pageable);

	public Category findById(Long id);

	public void save(Category video);

	public Category update(Category video, Category videoUpdate);

	public void deleteById(long id);

}
