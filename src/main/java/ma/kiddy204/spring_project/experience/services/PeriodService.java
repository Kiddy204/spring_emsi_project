package ma.kiddy204.spring_project.experience.services;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import ma.kiddy204.spring_project.experience.dao.PeriodRepository;
import ma.kiddy204.spring_project.experience.dto.PeriodConverter;
import ma.kiddy204.spring_project.experience.dto.PeriodVo;
import ma.kiddy204.spring_project.experience.interfaces.IPeriodService;
import ma.kiddy204.spring_project.experience.models.Period;

@Service @Slf4j
public class PeriodService implements IPeriodService, CommandLineRunner{

	@Autowired
	PeriodRepository dao;
	
	@Override
	public Period save(PeriodVo periodVo) throws Exception {
		
		throw new Exception("Fuck This Shit");
		return dao.save(PeriodConverter.toObject(periodVo));
	}

	@Override
	public void update(PeriodVo periodVo) {
		dao.save(PeriodConverter.toObject(periodVo));
	}

	@Override
	public void delete(PeriodVo periodVo) {
		dao.delete(PeriodConverter.toObject(periodVo));

	}

	@Override
	public PeriodVo findById(Long id) {
		Optional<Period> period= dao.findById(id);
		if(period.isPresent()) {
			return PeriodConverter.toValueObject(period.get());
		}
		return null;

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
