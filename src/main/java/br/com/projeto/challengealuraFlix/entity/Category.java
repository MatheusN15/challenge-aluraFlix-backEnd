package br.com.projeto.challengealuraFlix.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String tittle;
	@NotEmpty
	private String color;
	@JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Video> videos = new ArrayList<Video>();
	
	public Category() {
		super();
	}
	public Category(boolean d) {
		this.id = (long) 1;
		this.tittle = "LIVRE";
		this.color = "grenn";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
}
