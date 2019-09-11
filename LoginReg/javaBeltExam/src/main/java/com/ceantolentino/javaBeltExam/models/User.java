package com.ceantolentino.javaBeltExam.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=1, message="*Please fill up this field")
    private String name;
    @Size(min=1, message="*Please fill up this field")
    @Email(message="Email must be valid")
    private String email;
    @Size(min=8, message="*Password must be at least 8 characters")
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> rated_shows;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {}
    
    public User(String name, 
	    		String email, 
	    		String password,
				String passwordConfirmation,
				List<Show> rated_shows) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.rated_shows = rated_shows;
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


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
	public List<Show> getRated_shows() {
		return rated_shows;
	}

	public void setRated_shows(List<Show> rated_shows) {
		this.rated_shows = rated_shows;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
