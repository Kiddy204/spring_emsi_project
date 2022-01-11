package ma.kiddy204.spring_project.proposition.dto;

import ma.kiddy204.spring_project.proposition.models.Housing;
import ma.kiddy204.spring_project.proposition.models.Proposition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HousingConverter {
    public static HousingVo toValueObject(Housing housing) {
        if (housing == null || housing.getId() == null) return null;
        HousingVo vo = new HousingVo();
        vo.setId(housing.getId());
        vo.setCheckIn(housing.getCheckIn().toString());
        vo.setCheckOut(housing.getCheckOut().toString());
        vo.setPrice(housing.getPrice());
        vo.setType(housing.getType());
        return vo;
    }
    public static Housing toObject(HousingVo valueObject) {
        Housing housing = new Housing();
        housing.setId(valueObject.getId());
        housing.setCheckIn(LocalDate.parse(valueObject.getCheckIn()));
        housing.setCheckOut(LocalDate.parse(valueObject.getCheckOut()));
        housing.setPrice(valueObject.getPrice());
        housing.setType(valueObject.getType());
        return housing;
    }

    public static List<HousingVo> toListVo(List<Housing> listBo) {
        List<HousingVo> listVo = new ArrayList<>();
        for (Housing Housing : listBo) {
            listVo.add(toValueObject(Housing));
        }
        return listVo;
    }
}
