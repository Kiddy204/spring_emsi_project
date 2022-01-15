package ma.kiddy204.spring_project.experience.interfaces;

import ma.kiddy204.spring_project.experience.dto.ExperienceVo;
import ma.kiddy204.spring_project.experience.models.Experience;

public interface
IExperienceService {

	ExperienceVo findUserById(Long id);
	Experience save(ExperienceVo experienceVo);
	void update(ExperienceVo experienceVo);
	void delete(ExperienceVo experienceVo);
}
