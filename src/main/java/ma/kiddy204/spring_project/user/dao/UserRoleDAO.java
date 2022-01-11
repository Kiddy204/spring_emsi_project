package ma.kiddy204.spring_project.user.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.kiddy204.spring_project.user.model.User;
import ma.kiddy204.spring_project.user.model.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long>{
	
	List<UserRole> findByName(String name);
	//Optional<UserRole> findById(Long id);



}  