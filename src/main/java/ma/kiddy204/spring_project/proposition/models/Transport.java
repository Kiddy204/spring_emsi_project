package ma.kiddy204.spring_project.proposition.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    // avion, train, bateau ...
    private String type;
    private Float price;

}
