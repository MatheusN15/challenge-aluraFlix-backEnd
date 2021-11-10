package br.com.projeto.challengealuraFlix.service;

import java.util.List;

import br.com.projeto.challengealuraFlix.entity.Video;

public interface VideoService {

	public List<Video> findAll();

	public Video findById(Long id);

	public void save(Video video);

	public Video update(Video video, Video videoUpdate);

	public void deleteById(long id);

	public List<Video> findAllByCategoryId(long id);

	public List<Video> findByTittle(String tittle);
}
