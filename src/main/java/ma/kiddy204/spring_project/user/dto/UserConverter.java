package ma.kiddy204.spring_project.user.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ma.kiddy204.spring_project.user.model.User;

public class UserConverter {
	public static UserVo toValueObject(User user) {
		if (user == null || user.getId() == null) return null;
		UserVo vo = new UserVo(); 
		vo.setId(user.getId()); 
		vo.setUsername(user.getUsername()); 
		vo.setEmail(user.getEmail()); 
		vo.setDobDate(user.getDobDate().toString());
		user.setRole(user.getRole());
		vo.setPassword(user.getPassword()); 
		return vo;
	}
	public static User toObject(UserVo valueObject) {
		User user = new User(); 
		user.setId(valueObject.getId()); 
		user.setUsername(valueObject.getUsername()); 
		user.setEmail(valueObject.getEmail());	
		user.setDobDate(LocalDate.parse(valueObject.getDobDate()));
		user.setRole(valueObject.getRole());
		user.setPassword(valueObject.getPassword());
		return user;
	}
	public static List<UserVo> toListVo(List<User> listBo) {
		List<UserVo> listVo = new ArrayList<>();
		for (User User : listBo) {
			listVo.add(toValueObject(User)); 
		}
		return listVo; 
	}


}
