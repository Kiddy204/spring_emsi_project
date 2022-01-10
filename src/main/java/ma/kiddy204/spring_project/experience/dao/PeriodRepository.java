package ma.kiddy204.spring_project.experience.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.kiddy204.spring_project.experience.models.Period;

public interface PeriodRepository  extends JpaRepository<Period, Long>{

}
