package ma.kiddy204.spring_project.proposition.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proposition {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private Float estimatedBudget;
    private Float matchingScore;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Transport> transportOffers = new ArrayList<>();;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Housing> housingOffers = new ArrayList<>();;
}
