package model;

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
    private Long idButy;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nazwaButow;
    private Integer rozmiarButow;

    @Enumerated(EnumType.STRING)
    private RodzajButow rodzajButow;

    @OneToOne(mappedBy = "buty")
    private Komplet komplet;

}
