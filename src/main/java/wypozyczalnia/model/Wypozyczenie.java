package wypozyczalnia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import wypozyczalnia.dto.WypozyczenieDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWypozyczenie;

    @CreationTimestamp
    private LocalDateTime dataWypozyczenia;
    private LocalDateTime dataZwrotu;


    private Double cenaWypozyczenia;
    private Double cenaOstateczna;

    @ManyToOne
    private Komplet komplet;
    @ManyToOne
    private Klient klient;

    public WypozyczenieDTO mapWypozyczenieToDTO() {
        return new WypozyczenieDTO(idWypozyczenie, this.dataWypozyczenia, this.dataZwrotu, this.cenaWypozyczenia, this.cenaOstateczna);
    }
}
