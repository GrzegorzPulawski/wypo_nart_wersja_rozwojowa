package wypozyczalnia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWypozyczenie;

    private LocalDateTime dataWypozyczenia;
    private LocalDateTime dataZwrotu;
    private Double cenaWypozyczenia;
    private Double cenaOstateczna;

    @ManyToOne
    private Komplet komplet;
    @ManyToOne
    private Klient klient;
}
