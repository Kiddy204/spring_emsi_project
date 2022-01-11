package ma.kiddy204.spring_project.experience.interfaces;

import ma.kiddy204.spring_project.experience.dto.PeriodVo;
import ma.kiddy204.spring_project.experience.models.Period;

public interface IPeriodService {
	public Period save(PeriodVo periodVo) throws Exception;
	public void update(PeriodVo periodVo);
	public void delete(PeriodVo periodVo);
	public PeriodVo findById(Long id);

}
