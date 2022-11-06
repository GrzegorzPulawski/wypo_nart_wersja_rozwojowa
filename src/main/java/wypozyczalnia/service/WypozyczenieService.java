package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.CreateWypozyczenie;
import wypozyczalnia.dto.WypozyczenieDTO;
import wypozyczalnia.model.Klient;
import wypozyczalnia.model.Komplet;
import wypozyczalnia.model.Wypozyczenie;
import wypozyczalnia.repository.KlientRepository;
import wypozyczalnia.repository.KompletRepository;
import wypozyczalnia.repository.WypozyczenieRepository;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WypozyczenieService {
    private final WypozyczenieRepository wypozyczenieRepository;
    private final KompletRepository kompletRepository;
    private final KlientRepository klientRepository;

    public void addWypozyczenie(CreateWypozyczenie createWypozyczenie) {
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

                //sprawdzamy, czy komplet nie jest wypozyczony
                if (!isRented(komplet)) {
                    //kreujemy wypozyczenie
                    Wypozyczenie wypozyczenie = Wypozyczenie.builder()
                            .dataWypozyczenia(LocalDateTime.now())
                            //.cenaWypozyczenia(createWypozyczenie.getcenaWypozyczenia())
                            .cenaWypozyczenia(komplet.getCenaDoba())
                            .komplet(komplet)
                            .klient(klient)
                            .build();

                    // godziny / 24   = (int) 0
                    // godziny / 24.0 = 0.625
                    // Math.ceil(wynik) // <- zaokrągla w górę

                    wypozyczenieRepository.save(wypozyczenie);
                    return;
                }
            }
            throw new EntityNotFoundException("Zestaw jest niedostępny");
        }
    }

    public void returnWypozyczenie(Long idWypozyczenie) {
        // Szukam konkretnego wypozyczenia
        Optional<Wypozyczenie> wypozyczenieOptional = wypozyczenieRepository.findById(idWypozyczenie);
        if (wypozyczenieOptional.isPresent()) {
            Wypozyczenie wypozyczenie = wypozyczenieOptional.get();


            if (wypozyczenie.getDataZwrotu() == null) {
                //Ustawiam datę zwrotu
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
                //LocalDateTime localDateTime = LocalDateTime.now();

                wypozyczenie.setDataZwrotu(LocalDateTime.now());


                //Ustalamy ilość wypozyczonych dni
                LocalDateTime dataZwrotu = wypozyczenie.getDataZwrotu();
                LocalDateTime dataWypozyczenia = wypozyczenie.getDataWypozyczenia();

                Duration duration = Duration.between(dataWypozyczenia, dataZwrotu);

                //Zmieniamy róznicę w czasie w liczbę
                long durationSeconds = duration.getSeconds();
                double durationHouers = durationSeconds / 3600.0;

                double durationDays = Math.ceil(durationHouers / 24);

                //Pobieramy cenę za dobę
                Double cenaWypozyczenia = wypozyczenie.getCenaWypozyczenia();

                // ustawiamy cenę ostateczną
                Double cenaOstateczna = cenaWypozyczenia * durationDays;

                // Trzeba wprowadzić cene ostateczną do bazy
                wypozyczenie.setCenaOstateczna(cenaOstateczna);
                //aktualizacja w bazie
                wypozyczenieRepository.save(wypozyczenie);
                return;
            }
        }
        throw new EntityNotFoundException("Unable to find wypozyczenie with id: " + idWypozyczenie);
    }

    //Metoda sprawdza czy komplet jest wynajęty
    private boolean isRented(Komplet komplet) {
        for (Wypozyczenie wypozyczenie : komplet.getWypozyczenie()) {
            if (wypozyczenie.getDataZwrotu() != null) {
                return true;
            }
        }
        return false;
    }
    // Metoda listuje wszystkie wypozyczenia
    public List<WypozyczenieDTO> listWypozyczenie() {
        List<Wypozyczenie> wypozyczenieList = wypozyczenieRepository.findAll();
        List<WypozyczenieDTO> wypozyczenieDTOList = new ArrayList<>();
        for (Wypozyczenie wypozyczenie : wypozyczenieList) {
            wypozyczenieDTOList.add(wypozyczenie.mapWypozyczenieToDTO());
        }
        return wypozyczenieDTOList;
    }
    //Metoda wyświetla wszyskie dane z wybranej po ID encji
    public List<WypozyczenieDTO> showWypozyczenie(Long idWypozyczenie) {
        List<Wypozyczenie> wypozyczenieList = wypozyczenieRepository.findAll();
        List<WypozyczenieDTO> wypozyczenieDTOList = new ArrayList<>();
        for (Wypozyczenie wypozyczenie :wypozyczenieList){
            if (wypozyczenie.getIdWypozyczenie() == idWypozyczenie) {
                wypozyczenieDTOList.add(wypozyczenie.mapWypozyczenieToDTO());
            }
        }
            return wypozyczenieDTOList ;
    }
}
