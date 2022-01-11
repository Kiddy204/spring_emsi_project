package ma.kiddy204.spring_project.user.service;

import java.util.List;

import javax.management.relation.Role;

import ma.kiddy204.spring_project.user.model.User;
import ma.kiddy204.spring_project.user.model.UserRole;

public interface IUserRoleService {
	public void save(UserRole role);
	public void update(UserRole role);
	public void delete(UserRole role);

	public void addToUser(Long id, String roleName);
	public User getById(Long id); 
	public User getByUsername(String username);
	
	public List<UserRole> findAll();
	
}
