package ma.kiddy204.spring_project.experience.interfaces;

import ma.kiddy204.spring_project.experience.dto.PeriodVo;

public interface IPeriodService {
	public void save(PeriodVo periodVo);
	public void update(PeriodVo periodVo);
	public void delete(PeriodVo periodVo);
	public PeriodVo findById(Long id);

}
