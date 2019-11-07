package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Album;
import com.example.demo.entity.Image;


@SpringBootApplication
public class SpringBootSpringDataJpaRepositoryApplication {
	
	private ImageRepository imageRepository;
	private AlbumRepository albumRepository;
	
	
	public SpringBootSpringDataJpaRepositoryApplication(ImageRepository imageRepository,
			AlbumRepository albumRepository) {
		super();
		this.imageRepository = imageRepository;
		this.albumRepository = albumRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringDataJpaRepositoryApplication.class, args);
	}
	
	@Component
	class CourseCommand implements CommandLineRunner
	{

		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			List<Image> list=new ArrayList<Image>();
			Album tempAlbum=new Album();
			Image tempImage=new Image();
			tempAlbum.setName("Wedding");
			tempImage.setTitle("Family Photos");
			list.add(tempImage);
			tempImage.setAlbum(tempAlbum);
			tempAlbum.setImages(list);
			albumRepository.save(tempAlbum);
			imageRepository.save(tempImage);
		}
	}

}
