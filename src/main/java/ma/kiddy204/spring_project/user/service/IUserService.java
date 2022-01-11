package ma.kiddy204.spring_project.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.kiddy204.spring_project.user.dto.UserVo;

public interface IUserService extends UserDetailsService {
	public List<UserVo> getUsers();
	List<UserVo> findAll(int pageId, int size);

	public List<UserVo> findUserByEmail(String email);
	public List<UserVo> findUserByUsername(String username);
	public UserVo getUserById(long id);
	public UserVo getUserByUsername(String username);
	public void save(UserVo userVo);
	public void update(UserVo userVo);
	public void delete(UserVo userVo);
	public List <UserVo> sortBy(String fieldName);

	
}
