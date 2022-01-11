package ma.kiddy204.spring_project.experience.controllers;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import lombok.Data;
import ma.kiddy204.spring_project.experience.dto.PeriodConverter;
import ma.kiddy204.spring_project.experience.dto.PeriodVo;
import ma.kiddy204.spring_project.experience.interfaces.IPeriodService;
import ma.kiddy204.spring_project.experience.models.Period;
import ma.kiddy204.spring_project.experience.services.PeriodService;




@RestController
@RequestMapping(value = "api/period")
public class PeriodController {
	
	@Autowired
	private final IPeriodService periodService;
	
	PeriodController(PeriodService periodService){
		this.periodService= new PeriodService();
		
	}
	
	
	
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> 
	findPeriod(@PathVariable(name = "id") Long periodId) {
		PeriodVo periodVo = this.periodService.findById(periodId);
		if(periodVo != null)
			return new ResponseEntity<Object>(periodVo,HttpStatus.OK);
		return new ResponseEntity<>("Period not found",HttpStatus.OK);
	}
	
	
	@PostMapping(
			value = "/save",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
			)
	public ResponseEntity<Object> 
	createPeriod(@ModelAttribute PeriodVo periodVo){	
			periodService.save(periodVo);
			return new ResponseEntity<Object>(periodVo,HttpStatus.OK);
	}
	
	@PostMapping(value = "/period/update")
	public ResponseEntity<Object> 
	updatePeriod(@RequestBody PeriodVo periodVo){
		PeriodVo search = this.periodService.findById(periodVo.getId());
		
			periodService.save(periodVo);
			return new ResponseEntity<Object>(periodVo,HttpStatus.OK);
	}
	
	

}
