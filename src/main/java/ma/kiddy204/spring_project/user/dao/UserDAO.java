package ma.kiddy204.spring_project.user.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.kiddy204.spring_project.user.model.User;


public interface UserDAO extends JpaRepository<User, Long>{
	
	List<User> findByEmail(String email);
	List<User> findByUsername(String username);
	List<User> findById(long id);
	@Query(" SELECT e from User e ") List<User> findAll();


}
