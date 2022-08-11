package wypozyczalnia.model;

import wypozyczalnia.dto.CreateNartyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypozyczalnia.dto.NartyDTO;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Narty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNart;

    private String nazwaNart;
    private Integer dlugoscNart;

    @Enumerated(EnumType.STRING)
    private  RodzajNart rodzajNart;

    @OneToOne
    private Komplet komplet;


    public NartyDTO mapNartyToDTO() {return new NartyDTO(idNart, nazwaNart, dlugoscNart, rodzajNart);
    }
}
