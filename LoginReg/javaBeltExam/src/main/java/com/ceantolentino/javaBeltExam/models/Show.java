package com.ceantolentino.javaBeltExam.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=1, message="*Please fill up this field")
    private String title;
    @Size(min=1, message="*Please fill up this field")
    private String network;
    private double avgRating=0.0;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings", 
        joinColumns = @JoinColumn(name = "show_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users_who_rated;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Show() {}
    
	
	public Show(Long id, String title,
				String network, 
				List<User> users_who_rated) {
		this.id = id;
		this.title = title;
		this.network = network;
		this.users_who_rated = users_who_rated;
	}
	
	
	
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public List<User> getUsers_who_rated() {
		return users_who_rated;
	}
	public void setUsers_who_rated(List<User> users_who_rated) {
		this.users_who_rated = users_who_rated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
