package br.com.projeto.challengealuraFlix.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.challengealuraFlix.entity.Category;
import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.service.CategoryService;
import br.com.projeto.challengealuraFlix.service.VideoService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping
	public ResponseEntity<Page<Category>> listCategorys(Pageable pageable){
		Page<Category> listCategories = service.findAll(pageable);
		return ResponseEntity.ok(listCategories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> category(@PathVariable("id") long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveCategories(@RequestBody @Valid Category Category, UriComponentsBuilder uriBuilder){
		service.save(Category);
		
		URI uri = uriBuilder.path("/Categories/{id}").buildAndExpand(Category.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategories(@PathVariable("id") long id, @RequestBody @Valid Category Category){
		Category CategoryUpdate = service.findById(id);
		CategoryUpdate = service.update(Category, CategoryUpdate);
		return ResponseEntity.ok(CategoryUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategories(@PathVariable("id") long id){
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}/videos")
	public ResponseEntity<Page<Video>> videosByCategory(@PathVariable long id, Pageable pageable){
		Page<Video> listVideos = videoService.findAllByCategoryId(id, pageable);
		return ResponseEntity.ok(listVideos);
	}
}
