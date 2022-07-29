package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Komplet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKomplet;

    private String nazwaKomplet;
    private Double cenaDoba;

    @OneToMany(mappedBy = "komplet")
    private List<Narty> narty;
    @OneToMany(mappedBy = "komplet")
    private List<Buty> buty;

    @OneToMany(mappedBy = "komplet")
    private List<Wypozyczenie> wypozyczenie;

}
