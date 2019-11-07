package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Image;
@Service
public class ImageServiceImpl implements ImageService{
	private ImageRepository imageRepository;
	@Override
	@Transactional
	public List<Image> getAllCourses() {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}

	@Override
	@Transactional
	public void createCourse(Image image) {
		// TODO Auto-generated method stub
		imageRepository.save(image);
	}

	@Override
	@Transactional
	public Optional<Image> getCourseById(int theId) {
		// TODO Auto-generated method stub
		Optional<Image> image=imageRepository.findById(theId);
		return image;
	}

}
