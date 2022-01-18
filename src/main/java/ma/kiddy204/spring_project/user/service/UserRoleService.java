package ma.kiddy204.spring_project.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ma.kiddy204.spring_project.user.dao.UserDAO;
import ma.kiddy204.spring_project.user.dao.UserRoleDAO;
import ma.kiddy204.spring_project.user.dto.UserConverter;
import ma.kiddy204.spring_project.user.model.User;
import ma.kiddy204.spring_project.user.model.UserRole;

@Service @Transactional @Slf4j
public class UserRoleService implements IUserRoleService ,CommandLineRunner{
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	UserRoleDAO roleDAO;
	

	@Override
	public void save(UserRole role) {
		roleDAO.save(role);
		
	}

	@Override
	public void update(UserRole role) {
		roleDAO.save(role);
		
	}

	@Override
	public void delete(UserRole role) {
		roleDAO.delete(role);
	}

	@Override
	public void addToUser(Long id, String roleName) {
		User user= userDAO.getById(id);
		UserRole role= roleDAO.findByName(roleName).get(0);
		System.out.println(" Add  Role : " +role.getName());
		user.getRoles().add(role);
		//userDao.save(user);
		
		
	}
	public void addToUser(String username, String roleName) {
		User user= UserConverter.toObject(userService.getUserByUsername(username)); 
		UserRole role= roleDAO.findByName(roleName).get(0);
		System.out.println(" Add  Role : " +role.getName());
		user.getRoles().add(role);
		
		
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run(String... args) throws Exception {


		
	}

}
