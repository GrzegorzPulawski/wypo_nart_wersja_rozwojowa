package service;

import dto.NartyDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Narty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import repository.NartyRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class NartyService {
    private final NartyRepository nartyRepository;

    public void addNarty(Narty narty) {
        nartyRepository.save(narty);
    }

    public List<NartyDTO> findAll() {
        List<Narty> nartyList = nartyRepository.findAll();

        List<NartyDTO> nartyzListy = new ArrayList<>();
        for (Narty narty : nartyList) {
            nartyzListy.add(narty.mapNartDTO());
        }
        return nartyzListy;
    }
}
