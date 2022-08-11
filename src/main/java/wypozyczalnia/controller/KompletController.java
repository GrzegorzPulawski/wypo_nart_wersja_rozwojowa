package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wypozyczalnia.dto.CreateKompletRequest;
import wypozyczalnia.model.Komplet;
import wypozyczalnia.service.KompletService;

@Slf4j
@RestController
@RequestMapping("/api/komplet")
@RequiredArgsConstructor
public class KompletController {
    private final KompletService kompletService;

    @PostMapping
    public void createKomplet(@RequestBody CreateKompletRequest request){
        kompletService.add(request);
    }


}
