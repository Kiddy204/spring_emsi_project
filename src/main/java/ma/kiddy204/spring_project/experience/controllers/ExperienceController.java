package ma.kiddy204.spring_project.experience.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import ma.kiddy204.spring_project.experience.dto.ExperienceConverter;
import ma.kiddy204.spring_project.experience.dto.ExperienceVo;
import ma.kiddy204.spring_project.experience.dto.PeriodConverter;
import ma.kiddy204.spring_project.experience.dto.PeriodVo;
import ma.kiddy204.spring_project.experience.models.Experience;
import ma.kiddy204.spring_project.experience.models.Period;
import ma.kiddy204.spring_project.experience.services.ExperienceService;


@Data
class ExperienceForm{
	//Experience
	private String name;	
	private String description;
	//Period
	private String earliestDate;	
	private String latestDate;
	private int min_period;
	private int flexibility;
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

@RestController
@RequestMapping(value = "api/experience")
public class ExperienceController {
	
	@Autowired
	ExperienceService experienceService;
	
	@PostMapping(
			value = "/save",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
			)
	public ResponseEntity<Object> 
	createPeriod(@ModelAttribute ExperienceForm fullExperience){	
			Experience experience = new Experience();
			PeriodVo periodVo= new PeriodVo();
			experience.setName(fullExperience.getName());
			experience.setDescription(fullExperience.getDescription());
			periodVo.setEarliestDate(fullExperience.getEarliestDate());
			periodVo.setLatestDate(fullExperience.getLatestDate());
			periodVo.setFlexibility(fullExperience.getFlexibility());
			periodVo.setMin_period(fullExperience.getMin_period());
			experience.setPeriod( PeriodConverter.toObject(periodVo));
			experienceService.save(ExperienceConverter.toValueObject(experience));
			return new ResponseEntity<Object>(periodVo,HttpStatus.OK);
	}

}
