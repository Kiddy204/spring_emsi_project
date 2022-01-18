package ma.kiddy204.spring_project.experience.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ma.kiddy204.spring_project.experience.models.Period;
import ma.kiddy204.spring_project.user.model.User;

public class ExperienceVo {
	private Long id ;
	private String name;
	private String description;
	private Period period;
	private User user;
	//Contructors 
	public ExperienceVo() {
		super();
	}
	public ExperienceVo(String name, String description, Period period) {
		super();
		this.name = name;
		this.description = description;
		this.period = period;
	}
	public ExperienceVo(Long id, String name, String description, Period period) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.period = period;
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
		return "ExperienceVo [id=" + id + ", name=" + name + ", description=" + description + ", period=" + period.toString()
				+ "]";
	}
	
	
}
