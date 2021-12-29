package ma.kiddy204.spring_project.user.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ma.kiddy204.spring_project.user.model.UserRole;

public class UserRoleConverter {
	public UserRole toObject(UserRoleVo roleVo) {
		UserRole role= new UserRole();
		role.set_id(roleVo.get_id());
		role.setName(roleVo.getName());
		return role;
	}
	
	public UserRoleVo toValueObject(UserRole role) {
		UserRoleVo roleVo= new UserRoleVo();
		roleVo.set_id(role.get_id());
		roleVo.setName(role.getName());
		return roleVo;
	}
	
	public List<UserRoleVo> toListVo(List<UserRole> userRolesObjects){
		List<UserRoleVo> userVoList = new ArrayList<UserRoleVo>();
		for (UserRole userRoleObject : userRolesObjects) {
			userVoList.add(toValueObject(userRoleObject));
		}
		return userVoList;
	}

}
