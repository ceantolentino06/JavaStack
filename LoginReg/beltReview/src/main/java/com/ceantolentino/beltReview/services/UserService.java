package com.ceantolentino.beltReview.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceantolentino.beltReview.models.Comment;
import com.ceantolentino.beltReview.models.Event;
import com.ceantolentino.beltReview.models.User;
import com.ceantolentino.beltReview.repositories.CommentRepository;
import com.ceantolentino.beltReview.repositories.EventRepository;
import com.ceantolentino.beltReview.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

	public Event createEvent(Event event) {
		return eventRepository.save(event);
		
	}
	
	public Comment addEventComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public Event getEvent(Long id) {
		Optional<Event> optEvent = eventRepository.findById(id);
		if(optEvent.isPresent()) {
			return optEvent.get();
		}else {
			return null;
		}
	}
	
	public List<Event> getAllEventByState(String state){
		return eventRepository.findByStateEquals(state);
	}
	
	public List<Event> getAllEventByOtherState(String state) {
		return eventRepository.findByStateNot(state);
	}
	
	

	
}
