package com.ceantolentino.manyToMany.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> events_created;
    
    @ManyToMany(fetch = FetchType.EAGER)
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
        this.updatedAt = new Date();
    }
    
    public User() {}
	public User(String username, String password, List<Event> events_created, List<Event> joined_events) {
		this.username = username;
		this.password = password;
		this.events_created = events_created;
		this.joined_events = joined_events;
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof User))
	        return false;
	    
	    User e = (User) o;
	    return Objects.equals(id, e.getId());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public List<Event> getEvents_created() {
		return events_created;
	}
	public void setEvents_created(List<Event> events_created) {
		this.events_created = events_created;
	}
	public List<Event> getJoined_events() {
		return joined_events;
	}
	public void setJoined_events(List<Event> joined_events) {
		this.joined_events = joined_events;
	}
	
	
    
    
}
