package ma.Kiddy.the_list.user;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column( nullable = false)
	private String username;
	@Column( nullable = false)
	private String password;
	@Column( 
			nullable = false,
			unique = true
			)
	private String email;
	@Column( nullable = false)
	private LocalDate dobDate;
	@Column( nullable = false)
	private String role;
	//Constructors
	
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
	// to String 

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", dobDate=" + dobDate + "]";
	}
	

}
