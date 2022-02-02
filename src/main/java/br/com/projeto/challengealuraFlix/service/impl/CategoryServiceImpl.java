package br.com.projeto.challengealuraFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.projeto.challengealuraFlix.entity.Category;
import br.com.projeto.challengealuraFlix.repository.CategoryRepository;
import br.com.projeto.challengealuraFlix.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository repository;

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Category findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Category category) {
		if(category.getId()==null)
			category.setId(1L);
		repository.save(category);
	}

	@Override
	public Category update(Category category, Category categoryUpdate) {
		categoryUpdate.setTittle(category.getTittle());
		categoryUpdate.setColor(category.getColor());
		
		return repository.save(categoryUpdate);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}
}
