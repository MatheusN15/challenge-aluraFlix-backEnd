package br.com.projeto.challengealuraFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.repository.VideoRepository;
import br.com.projeto.challengealuraFlix.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoRepository repository;
	
	public List<Video> findAll(){
		return repository.findAll();
	}

	@Override
	public Video findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Video video) {
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

}
