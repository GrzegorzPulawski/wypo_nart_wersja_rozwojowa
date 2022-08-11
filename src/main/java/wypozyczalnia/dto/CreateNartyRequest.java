package wypozyczalnia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wypozyczalnia.model.RodzajNart;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNartyRequest {

    private String nazwaNart;
    private Integer dlugoscNart;
    private RodzajNart rodzajNart;
}
