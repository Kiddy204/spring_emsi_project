package ma.kiddy204.spring_project.user.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import ma.kiddy204.spring_project.experience.models.Experience;


public class UserVo {

		
		// Attributes
		private long id;
		private String username;
		private String password;
		private String email;
		@JsonFormat( pattern = "yyyy-MM-dd")
		private String dobDate;
		private String role;
		private Collection<Experience> experiences= new ArrayList<>();


	//Constructors

		public UserVo() {
			super();
		}	
		public UserVo(String username, String password, String email, String dobDate) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.dobDate = dobDate;
			this.role = " ";
		}
		public UserVo(long id, String username, String password, String email, String dobDate, String role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.dobDate = dobDate;
			this.role = role;
		}

	
		//Getters & Setters
		public long getId() {
			return id;
		}
		public void setId(long id) {
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDobDate() {
			return dobDate;
		}
		public void setDobDate(String dobDate) {
			this.dobDate = dobDate;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}

		public Collection<Experience> getExperiences() {
			return experiences;
		}
		public void setExperiences(Collection<Experience> experiences) {
			this.experiences = experiences;
		}

		@Override
			public String toString() {
				return "UserVo [id=" + id + ", username=" + username + ", email=" + email + ", dobDate=" + dobDate
						+ ", role=" + role + "]";
			}

		
}
