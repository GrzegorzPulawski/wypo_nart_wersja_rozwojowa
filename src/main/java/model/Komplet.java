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

    @OneToOne()
    private Narty narty;
    @OneToOne()
    private Buty buty;

    @OneToMany(mappedBy = "komplet")
    private List<Wypozyczenie> wypozyczenie;

}
