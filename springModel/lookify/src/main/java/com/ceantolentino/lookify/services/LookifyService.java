package com.ceantolentino.lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ceantolentino.lookify.models.Song;
import com.ceantolentino.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepo;
	
	public LookifyService(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
	public List<Song> allSongs(){
		return lookifyRepo.findAll();
	}
	
	public Song findSong(Long id) {
		Optional<Song> song = lookifyRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}else {
			return null;
		}
	}
	
	public Song addSong(Song song) {
		return lookifyRepo.save(song);
	}
	
	public List<Song> allSongsByArtist(String artist){
		return lookifyRepo.findByArtistContainingOrderByRatingDesc(artist);
	}
	
	public List<Song> topSongs(){
		return lookifyRepo.findFirst10ByOrderByRatingDesc();
	}
	
	public void delete(Long id) {
		lookifyRepo.deleteById(id);
	}
}
