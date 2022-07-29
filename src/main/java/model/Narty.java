package model;

import dto.NartyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Komplet komplet;

    public NartyDTO mapNartDTO(){
        return new NartyDTO(idNart,nazwaNart, dlugoscNart, rodzajNart);
    }

}
