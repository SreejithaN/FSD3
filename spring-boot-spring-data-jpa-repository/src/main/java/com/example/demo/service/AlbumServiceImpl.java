package com.example.demo.service;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.entity.Album;

public class AlbumServiceImpl implements AlbumService {
	private AlbumRepository albumRepository;
	
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		super();
		this.albumRepository=albumRepository;
	}

	@Override
	public void createAlbum(Album album) {
		albumRepository.save(album);
		
	}

}
