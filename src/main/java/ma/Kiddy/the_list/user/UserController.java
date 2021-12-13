package ma.Kiddy.the_list.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.Kiddy.the_list.user.model.User;

@RestController
@RequestMapping( path= "api")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService= userService; 		
	}
	
	@GetMapping
	public List<User>  getUsers(){
		return this.userService.getUsers();
	}
	
	

}
