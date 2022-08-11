package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.CreateKompletRequest;
import wypozyczalnia.model.Buty;
import wypozyczalnia.model.Komplet;
import wypozyczalnia.model.Narty;
import wypozyczalnia.repository.ButyRepository;
import wypozyczalnia.repository.KompletRepository;
import wypozyczalnia.repository.NartyRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KompletService {
    private final KompletRepository kompletRepository;
    private final NartyRepository nartyRepository;
    private final ButyRepository butyRepository;

    public void add(CreateKompletRequest request) {
        Optional<Buty> optionalButy = butyRepository.findById(request.getIdButy());
        if (optionalButy.isPresent()){
            Buty buty = optionalButy.get();
                Optional<Narty> optionalNarty = nartyRepository.findById(request.getIdNarty());
                if (optionalNarty.isPresent()){
                    Narty narty = optionalNarty.get();
                }
                    Komplet komplet = new Komplet(null, request.getNazwa(), request.getCenaDoba(), request.getIdNarty(), request.getIdButy(), request.getIdWypopzyczenie());
                     kompletRepository.save(komplet);


        }
    }
}
