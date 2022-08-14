package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.CreateKompletRequest;
import wypozyczalnia.dto.RentKompletRequest;
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

    @PatchMapping
    public void rentKomplet(@RequestBody RentKompletRequest request){
        kompletService.rent(request);
    }


}
