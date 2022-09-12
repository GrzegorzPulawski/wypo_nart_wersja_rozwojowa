package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.CreateWypozyczenie;
import wypozyczalnia.model.Klient;
import wypozyczalnia.model.Komplet;
import wypozyczalnia.model.Wypozyczenie;
import wypozyczalnia.repository.KlientRepository;
import wypozyczalnia.repository.KompletRepository;
import wypozyczalnia.repository.WypozyczenieRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WypozyczenieService {
    private final WypozyczenieRepository wypozyczenieRepository;
    private final KompletRepository kompletRepository;

    private final KlientRepository klientRepository;

    public void addWypozyczenie( CreateWypozyczenie createWypozyczenie) {
        // Jak sprawdzić czy komplet jest wypożyczony?
        //   - pobieramy szukany komplet
        //   - z kompletu bierzemy listę wynajmów
        //   - na liście szukamy: czy istnieje jakiś wynajem który nie ma ustawionej daty zwrotu
        //      jeśli data zwrotu wynajmu jest == null to znaczy że jest wynajęty



        Optional<Komplet> optionalKomplet = kompletRepository.findById(createWypozyczenie.getIdKomplet());
        if (optionalKomplet.isPresent()) {
            Komplet komplet = optionalKomplet.get();
            Optional<Klient> optionalKlient = klientRepository.findById(createWypozyczenie.getIdKlient());
            if (optionalKlient.isPresent()) {
                Klient klient = optionalKlient.get();

                Wypozyczenie wypozyczenie = Wypozyczenie.builder()
//                        .dataWypozyczenia(LocalDateTime.now())
//                        .cenaWypozyczenia(createWypozyczenie.getCenaWypozyczenia())
                        .cenaWypozyczenia(komplet.getCenaDoba())
                        .komplet(komplet)
                        .klient(klient)
                        .build();

                // Duration
                // Period

                // godziny = 15
                // godziny / 24   = (int) 0
                // godziny / 24.0 = 0.625
                //
                // Math.ceil(wynik) // <- zaokrągla w górę

                wypozyczenieRepository.save(wypozyczenie);
                return;
            }
            throw new EntityNotFoundException("Zestaw jest niedostępny");
        }
    }
}
