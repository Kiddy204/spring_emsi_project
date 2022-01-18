package ma.kiddy204.spring_project.user.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.kiddy204.spring_project.experience.dto.ExperienceConverter;
import ma.kiddy204.spring_project.experience.dto.ExperienceVo;
import ma.kiddy204.spring_project.experience.dto.PeriodVo;
import ma.kiddy204.spring_project.experience.interfaces.IExperienceService;
import ma.kiddy204.spring_project.experience.interfaces.IPeriodService;
import ma.kiddy204.spring_project.experience.models.Experience;
import ma.kiddy204.spring_project.experience.models.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import ma.kiddy204.spring_project.user.dto.UserConverter;
import ma.kiddy204.spring_project.user.dto.UserVo;
import ma.kiddy204.spring_project.user.model.User;
import ma.kiddy204.spring_project.user.model.UserRole;
import ma.kiddy204.spring_project.user.service.IUserRoleService;
import ma.kiddy204.spring_project.user.service.IUserService;
import ma.kiddy204.spring_project.user.service.UserRoleService;
import ma.kiddy204.spring_project.user.service.UserService;


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
@Data
class AddExperienceForm{
	//User
	private Long userId;
	//Experience
	private String name;
	private String description;
	//Period
	private String earliestDate;
	private String latestDate;
	private int min_period;
	private int flexibility;

	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getEarliestDate() {
		return earliestDate;
	}

	public String getLatestDate() {
		return latestDate;
	}

	public int getMin_period() {
		return min_period;
	}

	public int getFlexibility() {
		return flexibility;
	}
}


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private final IUserService userService;
	
	@Autowired
	private final IUserRoleService roleService;

	@Autowired
	private final IExperienceService  experienceService;

	@Autowired
	private final IPeriodService periodService;


	public UserController(
			UserService userService,
			UserRoleService roleService,
			IExperienceService experienceService, IPeriodService periodService) {
		this.userService= userService; 		
		this.roleService= roleService;
		this.experienceService = experienceService;
		this.periodService = periodService;
	}
	
	@GetMapping(value = "/users" ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserVo>  getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> 
	getUserById(@PathVariable(name = "id") Long userId){
		UserVo userSearch= userService.getUserById(userId);
		if(userSearch != null) {
			return new ResponseEntity<Object>(userSearch,HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found", HttpStatus.OK);
	}
	
	
	
	
	@PostMapping(value = "/save",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			consumes= {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<Object> 
	createUser(@ModelAttribute UserVo user){
//		UserVo userVo= new UserVo();
//		userVo.setDobDate(user.getDobDate());
//		userVo.setEmail(user.getEmail());
//		userVo.setPassword(user.getEmail());
//		userVo.setRole(user.getRole());
//		userVo.setUsername(user.getUsername());
		userService.save(user);
		return new ResponseEntity<>("User created successfully ! \n" + user.toString(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/{id}/update")
	public ResponseEntity<Object>
	updateUser(@RequestBody UserVo userVo){
		UserVo userSearch= userService.getUserById(userVo.getId());
		if(userSearch != null) {
			userService.update(userVo);
			return new ResponseEntity<>(userSearch, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.OK);
	}
	
	@GetMapping(value = "/token/refresh")
	public ResponseEntity<Object> 
	refreshToken(HttpServletRequest request, HttpServletResponse response) throws  IOException{
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token = authorizationHeader.substring("Bearer ".length()); 
				Algorithm algorithm= Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build(); 
				DecodedJWT decodedJWT = verifier.verify(refresh_token);
				String username = decodedJWT.getSubject(); 
				 User user= UserConverter.toObject(userService.getUserByUsername(username)) ;
				 String access_token= JWT.create()
							.withSubject(user.getUsername())
							.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000 ))
							.withIssuer(request.getRequestURL().toString() )
							.withClaim("roles",  user
									.getRoles()
									.stream()
									.map( UserRole :: getName)
									.collect(Collectors.toList()))
							.sign(algorithm);
			
					
					response.setHeader("access_token", access_token );
					response.setHeader("refresh_token ", refresh_token );
					Map<String, String> tokens = new HashMap<>();
					tokens.put("access_token", access_token);
					tokens.put("refresh_token", refresh_token);
					response.setContentType("application/json;charset=UTF-8");
					new ObjectMapper().writeValue(response.getOutputStream(), tokens); 
		  
			}catch(Exception exception) {
				System.err.println("caught error : "+ exception.getMessage());
				response.setHeader("error", exception.getMessage());
//				response.sendError(FORBIDDEN.value());
				Map<String, String> error = new HashMap<>();
				error.put("error_message", exception.getMessage());
				response.setContentType("application/json;charset=UTF-8");
				new ObjectMapper().writeValue(response.getOutputStream(), error); 

				
			}
		}else {
			throw new RuntimeException("Refresh token is missing");
		}
		
		return new ResponseEntity<>("New Role has been granted to User ", HttpStatus.OK);	
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
//	deleteUser(){}

	@PostMapping(
			value = "/experience/create",
			produces = { MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
	)
	public ResponseEntity<Object>
	addExperience(@ModelAttribute AddExperienceForm addExperienceForm){
		UserVo user = userService.getUserById(addExperienceForm.getUserId());

		PeriodVo periodVo= new PeriodVo();
		periodVo.setEarliestDate(addExperienceForm.getEarliestDate());
		periodVo.setLatestDate(addExperienceForm.getLatestDate());
		periodVo.setFlexibility(addExperienceForm.getFlexibility());
		periodVo.setMin_period(addExperienceForm.getMin_period());
		Period periodSaved = periodService.save(periodVo);

		ExperienceVo experience = new ExperienceVo(addExperienceForm.getName(),addExperienceForm.getDescription(),periodSaved);
		experience.setUser(UserConverter.toObject(user));
		Experience experienceSaved=experienceService.save(experience);
		this.userService.addExperience(user.getId(),(experienceSaved));
		//User savedUser=this.userService.save((user));
		return new ResponseEntity<Object>("User Experiecne is saved ! ",HttpStatus.OK);
	}

}
