package ma.kiddy204.spring_project.proposition.dao;

import ma.kiddy204.spring_project.proposition.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportDAO extends JpaRepository<Transport, Long> {
    List<Transport> findByType(String type);

}
