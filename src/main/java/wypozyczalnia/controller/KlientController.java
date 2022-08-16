package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.CreateKlientRequest;
import wypozyczalnia.dto.KlientDTO;
import wypozyczalnia.model.Klient;
import wypozyczalnia.service.KlientService;

import java.util.List;

@Slf4j
@RequestMapping("/api/klient")
@RestController
@RequiredArgsConstructor

public class KlientController {
    private final KlientService klientService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createKlient(@RequestBody CreateKlientRequest klientRequest){
        log.info("Create klient:"+klientRequest);
        klientService.add(klientRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<KlientDTO> klientDTOList(){
        log.info("Request: Lista klientow");
        return klientService.findAll();
    }

}
