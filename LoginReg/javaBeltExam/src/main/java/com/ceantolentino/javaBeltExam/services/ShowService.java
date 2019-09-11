package com.ceantolentino.javaBeltExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceantolentino.javaBeltExam.models.Rating;
import com.ceantolentino.javaBeltExam.models.Show;
import com.ceantolentino.javaBeltExam.repositories.RatingRepository;
import com.ceantolentino.javaBeltExam.repositories.ShowRepository;

@Service
public class ShowService {
	@Autowired
	private ShowRepository showRepo;
	
	@Autowired
	private RatingRepository ratingRepo;
	
	public Show createNewShow(Show show) {
		return showRepo.save(show);
	}
	
	public List<Show> getAllShows(){
		return showRepo.findAll();
	}
	
	public Show getShowByTitle(String title) {
		return showRepo.findByTitle(title);
	}

	public Show getShowById(Long id) {
		Optional<Show> optShow = showRepo.findById(id);
		if(optShow.isPresent()) {
			return optShow.get();
		}else {
			return null;
		}
	}
	
	public Rating rateAShow(Rating rating) {
		rating.setId(null);
		return ratingRepo.save(rating);
	}

	public List<Rating> getAllUsersRated(Show show) {
		return ratingRepo.findByShowOrderByRatingDesc(show);
	}
	
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
	
}
