package br.com.projeto.challengealuraFlix.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.challengealuraFlix.entity.Video;
import br.com.projeto.challengealuraFlix.repository.VideoRepository;

@Component
public class DummyData {

	@Autowired
	private VideoRepository repository;
	
	//@PostConstruct
	public void setarNoBancoDeDados(){
		
		Video video1 = new Video();
		video1.setTittle("O Hobbert");
		video1.setDescription("Uma pessoa muito pequena que se chama Hobbert sai em altas aventuras com um mago e os 7 anões");
		video1.setUrl("https://www.youtube.com/watch?v=4AKkpnCKa2I");
		
		Video video2 = new Video();
		video2.setTittle("Harry Pote");
		video2.setDescription("Abandonado, sozinho, e escravizado pela propria familia. Tem certeza que não é a Cinderela?");
		video2.setUrl("https://www.youtube.com/watch?v=4AKkpnCKa2I");
	
		repository.save(video1);
		repository.save(video2);
	}
}
