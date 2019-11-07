package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Image;

public interface ImageService {
	public List<Image> getAllCourses();
	public void createCourse(Image image);
	public Optional<Image> getCourseById(int theId);
}
