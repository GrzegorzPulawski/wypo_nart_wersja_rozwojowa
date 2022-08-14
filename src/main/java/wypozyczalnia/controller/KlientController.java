package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.dto.CreateKlientRequest;
import wypozyczalnia.model.Klient;
import wypozyczalnia.service.KlientService;

@Slf4j
@RequestMapping("/api/klient")
@RestController
@RequiredArgsConstructor

public class KlientController {
    private final KlientService klientService;

    public void createKlient(@PathVariable String nrTelefonu,  @RequestBody CreateKlientRequest klientRequest){
        klientService.add(nrTelefonu, klientRequest);

    }
}
