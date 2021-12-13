package ma.Kiddy.the_list.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ma.Kiddy.the_list.user.model.User;

@Service
public class UserService {
	public List<User>  getUsers(){
		return List.of( new User(
				"user1", 
				"pwd",  
				"user1@mail.com", 
				LocalDate.of(1995, 1, 1)
				) 
		);
			
	}
	

}
