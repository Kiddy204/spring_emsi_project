package ma.kiddy204.spring_project.experience.dto;

import ma.kiddy204.spring_project.experience.models.Experience;

public class ExperienceConverter {

	public static Experience toObject(ExperienceVo vo){
		Experience exp = new Experience();
		exp.setId(vo.getId());
		exp.setName(vo.getName());
		exp.setDescription(vo.getDescription());
		exp.setPeriod(vo.getPeriod());
		exp.setUser(vo.getUser());

		return exp;
	}
	
	public  static ExperienceVo toValueObject(Experience exp) {
		if (exp == null || exp.getId() == null) return null;
		ExperienceVo vo= new ExperienceVo();
		vo.setId(exp.getId());
		vo.setName(exp.getName());
		vo.setDescription(exp.getDescription());
		vo.setPeriod(exp.getPeriod());
		vo.setUser(exp.getUser());
		return vo;
	}
}
