package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.repository.WypozyczenieRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class WypozyczenieService {
    private final WypozyczenieRepository wypozyczenieRepository;

}
