package ma.kiddy204.spring_project.experience.models;

import ma.kiddy204.spring_project.user.model.User;

import javax.persistence.*;

@Entity
public class Experience {
	@Id @GeneratedValue
	private Long id ;
	
	@Column()
	private String name;
	
	
	@Column()
	private String description;
	
	@OneToOne
	private Period period;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;


	
	//Contructors 
	
	
	public Experience(String name, String description, Period period) {
		super();
		this.name = name;
		this.description = description;
		this.period = period;
	}

	public Experience() {
		super();
	}

	
	//Getters and Setters
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", name=" + name + ", description=" + description + ", period=" + period + "]";
	}
	
	
	
	

	
	

}
