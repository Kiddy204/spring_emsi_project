package ma.Kiddy.the_list.user.service;

import java.util.List;

import javax.management.relation.Role;

import ma.Kiddy.the_list.user.model.User;
import ma.Kiddy.the_list.user.model.UserRole;

public interface IUserRoleService {
	public void save(UserRole role);
	public void update(UserRole role);
	public void delete(UserRole role);

	public void addToUser(Long id, String roleName);
	public User getById(Long id); 
	public User getByUsername(String username);
	
	public List<UserRole> findAll();
	
}
