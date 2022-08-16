package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.CreateKlientRequest;
import wypozyczalnia.dto.KlientDTO;
import wypozyczalnia.model.Klient;
import wypozyczalnia.repository.KlientRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class KlientService {
    private final KlientRepository klientRepository;

    public void add(CreateKlientRequest klientRequest){
        boolean istnieje = klientRepository.existsByNrTelefonu(klientRequest.getNrTelefonu());
        if (!istnieje){
            Klient klient = new Klient(null,klientRequest.getNazwisko(), klientRequest.getImie(),klientRequest.getNrDowodu(), klientRequest.getNrTelefonu(), null);
               klientRepository.save(klient);
               return;
        }
        throw new EntityNotFoundException("Klient o podanym numerze telefonu już istnieje"+ klientRequest.getNrTelefonu());
    }

    public List<KlientDTO> findAll() {
        List<Klient> klientList = klientRepository.findAll();
        List<KlientDTO> klientDTOList = new ArrayList<>();
        for (Klient klient : klientList){
            klientDTOList.add(klient.mapKlientToDTO());
        }
        return klientDTOList;
    }
}
