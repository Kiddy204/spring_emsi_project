package ma.kiddy204.spring_project.experience.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.kiddy204.spring_project.experience.dao.ExperienceRepository;
import ma.kiddy204.spring_project.experience.dao.PeriodRepository;
import ma.kiddy204.spring_project.experience.dto.ExperienceConverter;
import ma.kiddy204.spring_project.experience.dto.ExperienceVo;
import ma.kiddy204.spring_project.experience.interfaces.IExperienceService;
import ma.kiddy204.spring_project.experience.models.Experience;
import ma.kiddy204.spring_project.user.dto.UserVo;

@Service
public class ExperienceService implements IExperienceService {


	@Autowired
	ExperienceRepository dao;
	
	@Override
	public ExperienceVo findUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<Experience> exp= dao.findById(id);
		if(exp.isPresent()) {
			return ExperienceConverter.toValueObject(exp.get());
		}
		return null;
	}

	@Override
	public void save(ExperienceVo experienceVo) {
		dao.save(ExperienceConverter.toObject(experienceVo));		
	}

	@Override
	public void update(ExperienceVo experienceVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ExperienceVo experienceVo) {
		// TODO Auto-generated method stub
		
	}

}
