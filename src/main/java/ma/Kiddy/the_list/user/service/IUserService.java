package ma.Kiddy.the_list.user.service;

import java.util.List;

import ma.Kiddy.the_list.user.User;
import ma.Kiddy.the_list.user.dto.UserVo;

public interface IUserService {
	public List<UserVo> getUsers();
	List<UserVo> findAll(int pageId, int size);

	public List<UserVo> findUserByEmail(String email);
	public List<UserVo> findUserByUsername(String username);
	public UserVo getUserById(long id);
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public List <UserVo> sortBy(String fieldName);


}
