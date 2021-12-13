package ma.Kiddy.the_list.user.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ma.Kiddy.the_list.user.User;
import ma.Kiddy.the_list.user.controller.UserController;
import ma.Kiddy.the_list.user.dao.UserDAO;
import ma.Kiddy.the_list.user.dto.UserConverter;
import ma.Kiddy.the_list.user.dto.UserVo;

@Service
public class UserService implements IUserService, CommandLineRunner{
	@Autowired
	UserDAO dao; 
	
	public List<UserVo>  getUsers(){
		List <User> users= dao.findAll();
		return UserConverter.toListVo(users);			
	}
	@Override
	public List<UserVo> findAll(int pageId, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVo> sortBy(String fieldName) {
		return  UserConverter.toListVo(dao.findAll(Sort.by(fieldName)));
	}

	@Override
	public List<UserVo> findUserByEmail(String email) {
		List<User> users = dao.findByEmail(email);
		return  UserConverter.toListVo(users);
	}

	@Override
	public List<UserVo> findUserByUsername(String username) {
		List<User> users = dao.findByUsername(username);
		return  UserConverter.toListVo(users);
	}

	@Override
	public UserVo getUserById(long id) {
		User user =dao.getById(id);
		return  UserConverter.toValueObject(user);
	}

	@Override
	public void save(User user) {
		dao.save(user);
	}
	
	@Override
	public void update(User user) {
		dao.save(user);		
	}
	@Override
	public void delete(User user) {
		dao.delete(user);	
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteAll();
		LocalDate date=LocalDate.of(1995, 1, 1);

		dao.save(new User("name1","12345", "name1@mail.com",  date));
		dao.save(new User("name2","12345", "name2@mail.com",  date)); 
		dao.save(new User("name3","12345", "name3@mail.com",  date)); 
		dao.save(new User("name4","12345", "name4@mail.com",  date)); 
		dao.save(new User("name5","12345", "name5@mail.com",  date)); 
		dao.save(new User("name6","12345", "name6@mail.com",  date));
		dao.save(new User("name7","12345", "name7@mail.com",  date)); 
		dao.save(new User("name8","12345", "name8@mail.com",  date));
		
	}


	

}
