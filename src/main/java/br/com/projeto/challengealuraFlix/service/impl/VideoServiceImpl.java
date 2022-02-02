package br.com.projeto.challengealuraFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.projeto.challengealuraFlix.entity.Category;
import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.repository.VideoRepository;
import br.com.projeto.challengealuraFlix.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoRepository repository;
	
	public Page<Video> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}

	@Override
	public Video findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Video video) {
		if(video.getCategory() == null) {
			Category category = new Category();
			video.setCategory(category);
		}
		repository.save(video);
	}

	@Override
	public Video update(Video video, Video videoUpdate) {
		videoUpdate.setTittle(video.getTittle());
		videoUpdate.setDescription(video.getDescription());
		videoUpdate.setUrl(video.getUrl());
		
		return repository.save(videoUpdate);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public Page<Video> findAllByCategoryId(long id, Pageable pageable) {
		return repository.findAllByCategoryId(id, pageable);
	}

	@Override
	public List<Video> findByTittle(String tittle) {
		return repository.findByTittleLike(tittle);
	}

}
