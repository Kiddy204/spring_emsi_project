package ma.Kiddy.the_list.user.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserVo {

		
		// Attributes
		private long id;
		private String username;
		private String password;
		private String email;
		private LocalDate dobDate;
		private String role;
		
		//Constructors

		public UserVo() {
			super();
		}	
		public UserVo(long id, String username, String password, String email, LocalDate dobDate, String role) {
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
		public LocalDate getDobDate() {
			return dobDate;
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

		
}
