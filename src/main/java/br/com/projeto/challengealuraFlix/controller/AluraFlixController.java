package br.com.projeto.challengealuraFlix.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class AluraFlixController {

	@Autowired
	private VideoService service;
	
	@GetMapping
	public ResponseEntity<List<Video>> listVideos(){
		List<Video> listVideos = service.findAll();
		return ResponseEntity.ok(listVideos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Video> video(@PathVariable("id") long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Video> saveVideos(@RequestBody Video video, UriComponentsBuilder uriBuilder){
		service.save(video);
		
		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new Video());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Video> updateVideos(@PathVariable("id") long id, @RequestBody Video video){
		Video videoUpdate = service.findById(id);
		videoUpdate = service.update(video, videoUpdate);
		return ResponseEntity.ok(videoUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVideos(@PathVariable("id") long id){
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
