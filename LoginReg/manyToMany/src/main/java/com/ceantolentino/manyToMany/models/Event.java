package com.ceantolentino.manyToMany.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=1, message="Name should be filled")
	private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    
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
    
	public Event(@Size(min = 1, message = "Name should be filled") String name, User host, List<User> joined_users) {
		this.name = name;
		this.host = host;
		this.joined_users = joined_users;
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
	public List<User> getJoined_users() {
		return joined_users;
	}
	public void setJoined_users(List<User> joined_users) {
		this.joined_users = joined_users;
	}
    
    
    
}
