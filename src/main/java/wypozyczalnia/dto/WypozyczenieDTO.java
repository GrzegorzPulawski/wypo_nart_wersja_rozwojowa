package wypozyczalnia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WypozyczenieDTO {
    private Long idWypozyczenie;
    private LocalDateTime dataWypozyczenia;
    private LocalDateTime dataZwrotu;
    private Double cenaWypozyczenia;
    private Double cenaOstateczna;
    private Long idKomplet;
    private String nrTelefonu;
    private String nazwisko;

}
