package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.service.WypozyczenieService;

@Slf4j
@RequestMapping("/api/wypozyczenie")
@RestController
@RequiredArgsConstructor
public class WypozyczenieController {
    private final WypozyczenieService wypozyczenieService;
}
