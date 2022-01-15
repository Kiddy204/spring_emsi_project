package ma.kiddy204.spring_project.proposition.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Housing {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    // types : hotel, airbnb , auberge
    private String type;
    private Float price;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkIn;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkOut;
}
