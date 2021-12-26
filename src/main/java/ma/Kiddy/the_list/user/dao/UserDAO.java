package ma.Kiddy.the_list.user.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.Kiddy.the_list.user.model.User;


public interface UserDAO extends JpaRepository<User, Long>{
	
	List<User> findByEmail(String email);
	List<User> findByUsername(String username);
	List<User> findById(long id);
	@Query(" SELECT e from User e ") List<User> findAll();


}
