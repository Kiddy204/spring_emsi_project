package ma.Kiddy.the_list.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import ma.Kiddy.the_list.user.dto.UserConverter;
import ma.Kiddy.the_list.user.dto.UserRoleVo;
import ma.Kiddy.the_list.user.dto.UserVo;
import ma.Kiddy.the_list.user.model.User;
import ma.Kiddy.the_list.user.service.IUserRoleService;
import ma.Kiddy.the_list.user.service.IUserService;
import ma.Kiddy.the_list.user.service.UserRoleService;
import ma.Kiddy.the_list.user.service.UserService;


@Data
class RoleToUserForm{
	private Long userId;
	private String roleName;
	//Getters
	public Long getUserId() {
		return userId;
	}
	public String getRoleName() {
		return roleName;
	}
	
}

@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	private final IUserService userService;
	
	@Autowired
	private final IUserRoleService roleService;
	

	public UserController(
			UserService userService,
			UserRoleService roleService
			) {
		this.userService= userService; 		
		this.roleService= roleService;
	}
	
	@GetMapping(value = "/users" ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserVo>  getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> 
	getUserById(@PathVariable(name = "id") Long userId){
		UserVo userSearch= userService.getUserById(userId);
		System.out.println(userSearch);
		if(userSearch != null) {
			return new ResponseEntity<Object>(userSearch,HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Object> 
	createUser(@RequestBody UserVo userVo){
		userService.save(userVo);
		return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/role/save")
	public ResponseEntity<Object> 
	createUserRole(@RequestBody UserVo userVo){
		userService.save(userVo);
		return new ResponseEntity<>("UserRole created successfully!", HttpStatus.CREATED);
	}
	
	
	@PostMapping(value = "/role/addtouser")
	public ResponseEntity<Object> 
	addRoleToUser(@RequestBody RoleToUserForm form ){
		this.roleService.addToUser(form.getUserId(), form.getRoleName());
		
		return new ResponseEntity<>("New Role has been granted to User ", HttpStatus.OK);
		
		
	}
	

}
