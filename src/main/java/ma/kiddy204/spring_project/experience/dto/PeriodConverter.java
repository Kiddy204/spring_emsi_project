package ma.kiddy204.spring_project.experience.dto;

import java.time.LocalDate;

import ma.kiddy204.spring_project.experience.models.Period;

public class PeriodConverter {

	
	public static PeriodVo toValueObject(Period period) {
		
		if (period == null || period.getId() == null) return null;
		PeriodVo vo = new PeriodVo();
		vo.setId(period.getId());
		vo.setEarliestDate(period.getEarliestDate().toString());
		vo.setLatestDate(period.getLatestDate().toString());
		vo.setFlexibility(period.getFlexibility());
		vo.setMin_period(vo.getMin_period());
		return vo;
	}
	
	public static Period toObject(PeriodVo vo) {
		Period period = new Period();
		period.setId(vo.getId()); 
		period.setEarliestDate(LocalDate.parse(vo.getEarliestDate()));
		period.setLatestDate(LocalDate.parse(vo.getLatestDate()));
		period.setFlexibility(vo.getFlexibility());
		period.setMin_period(vo.getMin_period());
		return period;	
	}
}
