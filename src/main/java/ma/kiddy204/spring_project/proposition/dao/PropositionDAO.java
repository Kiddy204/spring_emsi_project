package ma.kiddy204.spring_project.proposition.dao;

import ma.kiddy204.spring_project.proposition.models.Housing;
import ma.kiddy204.spring_project.proposition.models.Proposition;
import ma.kiddy204.spring_project.proposition.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropositionDAO extends JpaRepository<Proposition, Long> {
    List<Proposition> findAllByTransport(Transport transport);
    List<Proposition> findAllByTransportAndHousing(Transport transport, Housing housing);

}
