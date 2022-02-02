package br.com.projeto.challengealuraFlix.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.challengealuraFlix.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

	Page<Video> findAllByCategoryId(Long id, Pageable pageable);
	
	
	List<Video> findByTittleLike(String tittle);
}
