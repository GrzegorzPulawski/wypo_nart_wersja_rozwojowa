package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.ButyDTO;
import wypozyczalnia.dto.CreateButyRequest;
import wypozyczalnia.model.Buty;
import wypozyczalnia.repository.ButyRepository;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ButyService {
    public final ButyRepository butyRepository;
    public void addButy(CreateButyRequest createButyRequest) {
        Buty buty = new Buty(null, createButyRequest.getNazwaButow(), createButyRequest.getRozmiarButow(), createButyRequest.getRodzajButow(),null);
        butyRepository.save(buty);
    }

    public List<ButyDTO> findAll() {
        List<Buty> butyList= butyRepository.findAll();
        List<ButyDTO> butyDTOList= new ArrayList<>();
        for (Buty buty : butyList) {
            butyDTOList.add(buty.mapButyToDTO());
        }
        return butyDTOList;
    }
}
