package com.ceantolentino.beltReview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=1, message="First Name should be filled")
    private String firstName;
    @Size(min=1, message="Last Name should be filled")
    private String lastName;
    @Size(min=1, message="Email should be filled")
    private String email;
    @Size(min=1, message="Location should be filled")
    private String location;
    private String state;
    @Size(min=5, message="Password should be at least 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> events;
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events", 
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn(name = "event_id")
        )
    private List<Event> joined_events;
    
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	
    }
    
    public User() {}
    
 
	
    
	
	public User(@Size(min = 1, message = "First Name should be filled") String firstName,
			@Size(min = 1, message = "Last Name should be filled") String lastName,
			@Size(min = 1, message = "Email should be filled") String email,
			@Size(min = 1, message = "Location should be filled") String location, String state,
			@Size(min = 5, message = "Password should be at least 5 characters") String password,
			String passwordConfirmation, List<Event> events, List<Comment> comments, List<Event> joined_events) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.events = events;
		this.comments = comments;
		this.joined_events = joined_events;
	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if( obj== this ) return true;
//		if( !(obj instanceof User) ) return false;
//		
//		User u = (User) obj;
//		
//		return Double.compare(this.id, u.id) == 0;
//	}
	public List<Event> getJoined_events() {
		return joined_events;
	}
	public void setJoined_events(List<Event> joined_events) {
		this.joined_events = joined_events;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
       
}
