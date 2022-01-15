package ma.kiddy204.spring_project.proposition.dto;

import ma.kiddy204.spring_project.proposition.models.Proposition;
import ma.kiddy204.spring_project.user.dto.UserVo;
import ma.kiddy204.spring_project.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class PropositionConverter {
    public static PropositionVo toValueObject(Proposition proposition) {
        if (proposition == null || proposition.getId() == null) return null;
        PropositionVo vo = new PropositionVo();
        vo.setId(proposition.getId());
        vo.setEstimatedBudget(proposition.getEstimatedBudget());
        vo.setHousingOffers(proposition.getHousingOffers());
        vo.setTransportOffers(proposition.getTransportOffers());
        vo.setMatchingScore(proposition.getMatchingScore());
        return vo;
    }
    public static Proposition toObject(PropositionVo valueObject) {
        Proposition proposition = new Proposition();
        proposition.setId(valueObject.getId());
        proposition.setEstimatedBudget(valueObject.getEstimatedBudget());
        proposition.setHousingOffers(valueObject.getHousingOffers());
        proposition.setTransportOffers(valueObject.getTransportOffers());
        proposition.setMatchingScore(valueObject.getMatchingScore());
        return proposition;
    }

    public static List<PropositionVo> toListVo(List<Proposition> listBo) {
        List<PropositionVo> listVo = new ArrayList<>();
        for (Proposition Proposition : listBo) {
            listVo.add(toValueObject(Proposition));
        }
        return listVo;
    }
}
