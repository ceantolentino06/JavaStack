package com.ceantolentino.manyToMany.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceantolentino.manyToMany.models.Event;
import com.ceantolentino.manyToMany.models.User;
import com.ceantolentino.manyToMany.repositories.EventRepository;
import com.ceantolentino.manyToMany.repositories.UserRepository;

@Service
public class AppService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	// register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    public User updateUser(User user) {
    	return userRepo.save(user);
    }
    
    public User findByUsername(String email) {
        return userRepo.findByUsername(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String username, String password) {
        // first find the user by email
        User user = userRepo.findByUsername(username);
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
    
    public List<Event> getAllEvents(){
    	return eventRepo.findAll();
    }

	public Event createNewEvent(Event event) {
		return eventRepo.save(event);		
	}

	public Event getEventById(Long id) {
		// TODO Auto-generated method stub
		Optional<Event> optEvent = eventRepo.findById(id);
		if(optEvent.isPresent()){
			return optEvent.get();
		}else {
			return null;
		}
	}
}
