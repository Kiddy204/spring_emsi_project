package ma.kiddy204.spring_project.proposition.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.kiddy204.spring_project.proposition.models.Housing;
import ma.kiddy204.spring_project.proposition.models.Transport;

import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
public class PropositionVo {
    private Long id;
    private Float estimatedBudget;
    private Float matchingScore;

    private Collection<Transport> transportOffers = new ArrayList<>();;

    private Collection<Housing> housingOffers = new ArrayList<>();;

    public PropositionVo(Float estimatedBudget,Float matchingScore,Collection<Transport> transportOffers,Collection<Housing> housingOffers){
        this.estimatedBudget=estimatedBudget;
        this.matchingScore=matchingScore;
        this.transportOffers=transportOffers;
        this.housingOffers=housingOffers;
    }
}
