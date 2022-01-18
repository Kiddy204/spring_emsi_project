package ma.kiddy204.spring_project.user.service;

import java.util.List;

import ma.kiddy204.spring_project.experience.models.Experience;
import ma.kiddy204.spring_project.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import ma.kiddy204.spring_project.user.dto.UserVo;

public interface IUserService extends UserDetailsService {
	public List<UserVo> getUsers();
	List<UserVo> findAll(int pageId, int size);


	public List<UserVo> findUserByEmail(String email);
	public List<UserVo> findUserByUsername(String username);
	public UserVo getUserById(long id);
	public UserVo getUserByUsername(String username);
	public User save(UserVo userVo);
	public void update(UserVo userVo);
	public void delete(UserVo userVo);
	public List <UserVo> sortBy(String fieldName);
	public void addExperience(Long id, Experience Experience);



}
