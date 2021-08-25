package br.com.projeto.challengealuraFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.service.VideoService;

@RestController
@RequestMapping("/video")
public class AluraFlixController {

	@Autowired
	private VideoService service;
	
	@GetMapping
	public ResponseEntity<List<Video>> listVideos(){
		List<Video> listVideos = service.findAll();
		return ResponseEntity.ok(listVideos);
	}
}
