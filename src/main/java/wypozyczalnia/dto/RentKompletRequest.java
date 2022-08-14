package wypozyczalnia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentKompletRequest {
    private Long idKomplet;
    private Long idKlient;
    private Double cenaWypozyczenia;
}
