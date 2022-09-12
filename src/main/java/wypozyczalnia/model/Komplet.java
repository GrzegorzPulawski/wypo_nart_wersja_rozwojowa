package wypozyczalnia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypozyczalnia.dto.KompletDTO;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Komplet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKomplet;

    private String nazwaKomplet;
    private Double cenaDoba;

    @OneToOne(mappedBy = "komplet")
    private Narty narty;

    @OneToOne(mappedBy = "komplet")
    private Buty buty;

    @OneToMany(mappedBy = "komplet")
    private List<Wypozyczenie> wypozyczenie;

    public KompletDTO mapButyToDTO() {
        return new KompletDTO(null, this.nazwaKomplet, this.cenaDoba);
    }
}
