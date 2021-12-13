package ma.Kiddy.the_list.user.model;

import java.time.LocalDate;
import java.util.Date;

public class User {
	
	private long id;
	private String userrname;
	private String password;
	private String email;
	private LocalDate dobDate;
	//Constructors
	
	public User() {
		super();
	}

	public User(String userrname, String password, String email, LocalDate localDate) {
		super();
		this.userrname = userrname;
		this.password = password;
		this.email = email;
		this.dobDate = localDate;
	}


	
	// Getters and Setters

	
	public long getId() {
		return id;
	}


	public String getUserrname() {
		return userrname;
	}

	public void setUserrname(String userrname) {
		this.userrname = userrname;
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
		return "User [id=" + id + ", userrname=" + userrname + ", email=" + email + ", dobDate=" + dobDate + "]";
	}
	

}
