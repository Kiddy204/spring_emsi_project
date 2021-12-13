package ma.Kiddy.the_list.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.Kiddy.the_list.user.User;
import ma.Kiddy.the_list.user.dto.UserVo;
import ma.Kiddy.the_list.user.service.IUserService;
import ma.Kiddy.the_list.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	private final IUserService userService;
	

	public UserController(UserService userService) {
		this.userService= userService; 		
	}
	
	@GetMapping(value = "/users/list" ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserVo>  getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable(name = "id") Long userId){
		UserVo userSearch= userService.getUserById(userId);
		System.out.println(userSearch);
		if(userSearch != null) {
			return new ResponseEntity<Object>(userSearch,HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.OK);
	}
	
	

}
