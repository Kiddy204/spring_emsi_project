package ma.kiddy204.spring_project.experience.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ma.kiddy204.spring_project.experience.models.Experience;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{

}
