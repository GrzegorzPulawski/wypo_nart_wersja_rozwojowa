package wypozyczalnia.model;

import wypozyczalnia.dto.ButyDTO;
import wypozyczalnia.dto.CreateButyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Buty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idButy;

    private String nazwaButow;
    private Integer rozmiarButow;

    @Enumerated(EnumType.STRING)
    private RodzajButow rodzajButow;

    @OneToOne
    private Komplet komplet;

    public ButyDTO mapButyToDTO(){
        return new ButyDTO(idButy, nazwaButow, rozmiarButow, rodzajButow);
    }

}
