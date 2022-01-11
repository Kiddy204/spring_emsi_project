package ma.kiddy204.spring_project.experience.dto;

import ma.kiddy204.spring_project.experience.models.Experience;

public class ExperienceConverter {

	public static Experience toObject(ExperienceVo vo){
		Experience exp = new Experience();
		if(vo.getId() != null) {
			exp.setId(vo.getId());
		}
		if(vo.getName() != null) {
			exp.setName(vo.getName());

		}
		if(vo.getDescription() != null) {
			exp.setDescription(vo.getDescription());

		}
		if(vo.getPeriod()!=null) {			
			exp.setPeriod(vo.getPeriod());
		}
		return exp;
	}
	
	public  static ExperienceVo toValueObject(Experience exp) {
		if (exp == null || exp.getId() == null) return null;
		ExperienceVo vo= new ExperienceVo();
		vo.setId(exp.getId());
		vo.setName(exp.getName());
		vo.setDescription(exp.getDescription());
		vo.setPeriod(exp.getPeriod());
		return vo;
	}
}
