package ma.kiddy204.spring_project.proposition.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransportVo {
    private Long id;
    // avion, train, bateau ...
    private String type;
    private Float price;

    public TransportVo(String type, Float price) {
        this.type = type;
        this.price = price;
    }
}
