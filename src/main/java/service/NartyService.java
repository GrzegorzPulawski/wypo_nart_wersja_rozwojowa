package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Narty;
import org.springframework.stereotype.Service;
import repository.NartyRepository;
@Slf4j
@Service
@RequiredArgsConstructor

public class NartyService {
    private final NartyRepository nartyRepository;

    public void addNarty(Narty narty) {
        nartyRepository.save(narty);

    }
}
