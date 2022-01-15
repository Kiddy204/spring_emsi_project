package ma.kiddy204.spring_project.proposition.dto;

import ma.kiddy204.spring_project.proposition.models.Proposition;
import ma.kiddy204.spring_project.proposition.models.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportConverter {
    public static TransportVo toValueObject(Transport transport) {
        if (transport == null || transport.getId() == null) return null;
        TransportVo vo = new TransportVo();
        vo.setId(transport.getId());
        vo.setType(transport.getType());
        vo.setPrice(transport.getPrice());
        return vo;
    }
    public static Transport toObject(TransportVo valueObject) {
        Transport transport = new Transport();
        transport.setId(valueObject.getId());
        transport.setType(valueObject.getType());
        transport.setPrice(valueObject.getPrice());
        return transport;
    }

    public static List<TransportVo> toListVo(List<Transport> listBo) {
        List<TransportVo> listVo = new ArrayList<>();
        for (Transport Transport : listBo) {
            listVo.add(toValueObject(Transport));
        }
        return listVo;
    }
}
