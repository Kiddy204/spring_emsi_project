package ma.kiddy204.spring_project.experience.controllers;

import lombok.extern.slf4j.Slf4j;
import ma.kiddy204.spring_project.experience.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/experience")
@Slf4j
public class ExperienceController {

	@Autowired
	ExperienceService experienceService;

	@Autowired
	PeriodService periodService;

	@PostMapping(
			value = "/save",
			produces = { MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
			)
	public ResponseEntity<Object>
	createExperience(@ModelAttribute ExperienceForm fullExperience){
			PeriodVo periodVo= new PeriodVo();
			periodVo.setEarliestDate(fullExperience.getEarliestDate());
			periodVo.setLatestDate(fullExperience.getLatestDate());
			periodVo.setFlexibility(fullExperience.getFlexibility());
			periodVo.setMin_period(fullExperience.getMin_period());
			Period periodSaved = periodService.save(periodVo);
			ExperienceVo experience = new ExperienceVo(fullExperience.getName(),fullExperience.getDescription(),periodSaved);

			Experience experienceSaved=experienceService.save(experience);
			return new ResponseEntity<Object>(experienceSaved,HttpStatus.OK);
	}

}
