package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.CreateWypozyczenie;
import wypozyczalnia.dto.WypozyczenieDTO;
import wypozyczalnia.service.WypozyczenieService;

import java.util.List;

@Slf4j
@RequestMapping("/api/wypozyczenie")
@RestController
@RequiredArgsConstructor
public class WypozyczenieController {
    private final WypozyczenieService wypozyczenieService;
    
    @PostMapping("/rent")
    public void rentKomplet( @RequestBody CreateWypozyczenie createWypozyczenie){
        log.info("Request wypozyczenie kompletu z id: " + createWypozyczenie);
        wypozyczenieService.addWypozyczenie(createWypozyczenie);
    }
    // 1. Dodanie wypozyczenia
    //  Tworzymy Wypozyczenie gdzie cena wypozyczenia (cenaWypozyczenia) = 30 zł [per doba]
    //                              cena ostateczna   (cenaOstateczna)   = null
    @PostMapping ("/return")
    public void returnKomplet(@RequestParam Long idWypozyczenie){
        log.info("Request zwrot kompletu z id: "+ idWypozyczenie);
        wypozyczenieService.returnWypozyczenie(idWypozyczenie);
    }
    // 2. Zwrot kompletu (wypozyczenie)
    //  Szukamy wypozyczenia konkretnego (po id)
    //                              cena wypozyczenia nie zmienia sie    = 30 zł [per doba]
    //                              cena ostateczna = cena wypozyczenia * ilość dób + [koszta dodatkowe] (dodatkowy parametr)
    //                                                                     3 dni * 30 zł = 90 zł
    //
    @GetMapping("/list")
    public List<WypozyczenieDTO> wypozyczenieDTOList(){return wypozyczenieService.listWypozyczenie();}
}
