package wypozyczalnia.service;

import wypozyczalnia.dto.CreateNartyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wypozyczalnia.dto.NartyDTO;
import wypozyczalnia.model.Narty;
import org.springframework.stereotype.Service;
import wypozyczalnia.repository.NartyRepository;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class NartyService {
    private final NartyRepository nartyRepository;
    public void addNarty(CreateNartyRequest createNartyRequest) {
        Narty narty = new Narty(null, createNartyRequest.getNazwaNart(), createNartyRequest.getDlugoscNart(), createNartyRequest.getRodzajNart(), null);
        nartyRepository.save(narty);
    }

    public List<NartyDTO> findAll() {
        List<Narty> nartyList = nartyRepository.findAll();

        List<NartyDTO> nartyDTOList = new ArrayList<>();
        for (Narty narty : nartyList) {
            nartyDTOList.add(narty.mapNartyToDTO());
        }
        return nartyDTOList;
    }
}
