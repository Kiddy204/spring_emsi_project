package ma.kiddy204.spring_project.experience.interfaces;

import java.util.List;

import ma.kiddy204.spring_project.experience.dto.ExperienceVo;
import ma.kiddy204.spring_project.user.dto.UserVo;

public interface IExperienceService {

	public ExperienceVo findUserById(Long id);
	public void save(ExperienceVo experienceVo);
	public void update(ExperienceVo experienceVo);
	public void delete(ExperienceVo experienceVo);
}
