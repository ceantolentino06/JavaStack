package com.ceantolentino.lookify.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import com.ceantolentino.lookify.models.Song;

public interface LookifyRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	
	List<Song> findByArtistContainingOrderByRatingDesc(String artist);

	List<Song> findFirst10ByOrderByRatingDesc();
}
