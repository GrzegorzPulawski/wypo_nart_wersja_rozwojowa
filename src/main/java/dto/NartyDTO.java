package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.RodzajButow;
import model.RodzajNart;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NartyDTO {

    private Long idNart;
    private String nazwaNart;
    private Integer dlugoscNart;
    private RodzajNart rodzajNart;
}
