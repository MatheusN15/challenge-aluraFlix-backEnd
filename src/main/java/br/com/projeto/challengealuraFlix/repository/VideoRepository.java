package br.com.projeto.challengealuraFlix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.challengealuraFlix.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

	List<Video> findAllByCategoryId(Long id);
	
	
	List<Video> findByTittleLike(String tittle);
}
