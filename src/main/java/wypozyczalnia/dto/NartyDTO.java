package wypozyczalnia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypozyczalnia.model.RodzajNart;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NartyDTO {
    private Long idNart;
    private String nazwaNart;
    private Integer dlugoscNart;
    private RodzajNart rodzajNart;
}
