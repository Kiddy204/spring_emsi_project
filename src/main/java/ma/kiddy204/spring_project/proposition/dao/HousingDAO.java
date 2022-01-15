package ma.kiddy204.spring_project.proposition.dao;

import ma.kiddy204.spring_project.proposition.models.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HousingDAO extends JpaRepository<Housing, Long> {
    List<Housing> findByType(String type);

}
