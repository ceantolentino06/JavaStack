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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=1, message="Name should be filled")
	private String name;
	@Future(message="Date should be valid")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@Size(min=1, message="Location should be filled")
	private String location;
	private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;
    
    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )     
    private List<User> joined_users;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Event() { }
    
    
    
	
	public Event(@Size(min = 1, message = "Name should be filled") String name,
			@Future(message = "Date should be valid") Date date,
			@Size(min = 1, message = "Location should be filled") String location, String state, User host,
			List<Comment> comments, List<User> joined_users) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
		this.state = state;
		this.host = host;
		this.comments = comments;
		this.joined_users = joined_users;
	}
	
	
	public List<User> getJoined_users() {
		return joined_users;
	}
	public void setJoined_users(List<User> joined_users) {
		this.joined_users = joined_users;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
    
	
    
	
}
