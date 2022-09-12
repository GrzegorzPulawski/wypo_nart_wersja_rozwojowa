package wypozyczalnia.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KompletDTO {
    private Long idKomplet;

    private String nazwaKomplet;
    private Double cenaDoba;

//    public KompletDTO() {
//    }

//    public KompletDTO(Long idKomplet, String nazwaKomplet, Double cenaDoba) {
//        this.idKomplet = idKomplet;
//        this.nazwaKomplet = nazwaKomplet;
//        this.cenaDoba = cenaDoba;
//    }
}
