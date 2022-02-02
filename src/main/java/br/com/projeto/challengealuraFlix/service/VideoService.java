package br.com.projeto.challengealuraFlix.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.projeto.challengealuraFlix.entity.Video;

public interface VideoService {

	public Page<Video> findAll(Pageable pageable);

	public Video findById(Long id);

	public void save(Video video);

	public Video update(Video video, Video videoUpdate);

	public void deleteById(long id);

	public List<Video> findByTittle(String tittle);

	public Page<Video> findAllByCategoryId(long id, Pageable pageable);
}
