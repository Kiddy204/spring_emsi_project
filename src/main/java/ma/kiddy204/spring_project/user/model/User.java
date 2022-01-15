package ma.kiddy204.spring_project.user.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import ma.kiddy204.spring_project.experience.models.Experience;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity @Data 
public class User implements UserDetails {
	
	@Id @GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;
	@Column()
	private String password;
	@Column(unique = true)
	private String email;
	@Column()
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dobDate;
	@Column() 
	private String role;
	
	@ManyToMany(fetch = FetchType.EAGER) // allow me to fetch roles each time i fetch a user
	private Collection<UserRole> roles= new ArrayList<>();
	//Constructors

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Experience>  experiences= new ArrayList<>();

	
	public User() {
		super();
	}

	public User(String userrname, String password, String email, LocalDate localDate) {
		super();
		this.username = userrname;
		this.password = password;
		this.email = email;
		this.dobDate = localDate;
		this.role="user";
	}


	
	// Getters and Setters

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDobDate(LocalDate dobDate) {
		this.dobDate = dobDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public Collection<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userrname) {
		this.username = userrname;
	}

	public LocalDate getDobDate() {
		return dobDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Collection<Experience> experiences) {
		this.experiences = experiences;
	}

	

	// to String

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", dobDate=" + dobDate + "]";
	}
	
	//User Details
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
	

}
