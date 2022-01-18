package ma.kiddy204.spring_project.user.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ma.kiddy204.spring_project.experience.models.Experience;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ma.kiddy204.spring_project.user.dao.UserDAO;
import ma.kiddy204.spring_project.user.dao.UserRoleDAO;
import ma.kiddy204.spring_project.user.dto.UserConverter;
import ma.kiddy204.spring_project.user.dto.UserVo;
import ma.kiddy204.spring_project.user.model.User;
import ma.kiddy204.spring_project.user.model.UserRole;

@Service
@Slf4j
public class UserService implements IUserService, CommandLineRunner {
	@Autowired
	UserDAO userDAO;

	@Autowired
	UserRoleDAO roleDAO;

	@Autowired
	UserRoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDAO.findByUsername(username).get(0);
		List<SimpleGrantedAuthority> springSecurityAuthorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			springSecurityAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				springSecurityAuthorities);

	}

	public List<UserVo> getUsers() {
		List<User> users = userDAO.findAll();
		return UserConverter.toListVo(users);
	}

	@Override
	public List<UserVo> findAll(int pageId, int size) {
		List<User> users = userDAO.findAll();
		return UserConverter.toListVo(users);
	}

	@Override
	public List<UserVo> sortBy(String fieldName) {
		return UserConverter.toListVo(userDAO.findAll(Sort.by(fieldName)));
	}

	@Override
	public void addExperience(Long id, Experience experience) {

		User user= userDAO.getById(id);
	    user.getExperiences().add(experience);
		user= userDAO.getById(id);
		Collection<Experience> experiences =user.getExperiences();
 		userDAO.save(user);



	}


	@Override
	public List<UserVo> findUserByEmail(String email) {
		List<User> users = userDAO.findByEmail(email);
		return UserConverter.toListVo(users);
	}

	@Override
	public List<UserVo> findUserByUsername(String username) {
		List<User> users = userDAO.findByUsername(username);
		return UserConverter.toListVo(users);
	}

	@Override
	public UserVo getUserById(long id) {
		User user = userDAO.getById(id);
		return UserConverter.toValueObject(user);
	}

	@Override
	public User save(UserVo userVo) {
		String password =  userVo.getPassword();
		
			String encrypted= passwordEncoder.encode(password);
			userVo.setPassword(encrypted);

			userDAO.save(UserConverter.toObject(userVo));


		return null;
	}

	@Override
	public void update(UserVo userVo) {
		userDAO.save(UserConverter.toObject(userVo));
	}

	@Override
	public void delete(UserVo userVo) {
		userDAO.delete(UserConverter.toObject(userVo));
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userDAO.deleteAll();
		LocalDate date = LocalDate.of(1995, 1, 1);
		roleDAO.deleteAll();

		roleService.save(new UserRole("USER"));
		roleService.save(new UserRole("ADMIN"));

		// Save Users
		save(new UserVo("admin", "12345", "name3@mail.com", "1990-10-10"));
		save(new UserVo("user", "12345", "name1@mail.com", "1990-10-10"));
		save(new UserVo("joe", "12345", "name2@mail.com", "1990-10-10"));
		save(new UserVo("sarah", "12345", "name4@mail.com", "1990-10-10"));
		save(new UserVo("aymane", "12345", "name5@mail.com", "1990-10-10"));
		save(new UserVo("Wes", "12345", "name6@mail.com", "1990-10-10"));
		save(new UserVo("Rami", "12345", "name7@mail.com", "1990-10-10"));
		save(new UserVo("Hamid", "12345", "name8@mail.com", "1990-10-10"));

		List<UserVo> users = this.getUsers();
		for (UserVo user : users) {
			String nameString = user.getUsername();
			if (nameString.equals("admin")) {
				roleService.addToUser(user.getId(), "ADMIN");

			} else {
				roleService.addToUser(user.getId(), "USER");
			}
		}

	}

	@Override
	public UserVo getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return UserConverter.toValueObject(userDAO.findByUsername(username).get(0));
	}

}
