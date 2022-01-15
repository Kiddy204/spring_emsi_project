package ma.kiddy204.spring_project.proposition.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HousingVo {

    private Long id;
    // types : hotel, airbnb , auberge
    private String type;
    private Float price;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String checkIn;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String checkOut;


    public HousingVo(String type, Float price, String checkIn, String checkOut) {
        this.type = type;
        this.price = price;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
