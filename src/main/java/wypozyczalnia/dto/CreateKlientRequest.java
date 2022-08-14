package wypozyczalnia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateKlientRequest {
    private String nazwisko;
    private String imie;
    private String nrDowodu;
    private String nrTelefonu;

}
