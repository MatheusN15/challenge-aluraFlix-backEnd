package br.com.projeto.challengealuraFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.challengealuraFlix.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

}
