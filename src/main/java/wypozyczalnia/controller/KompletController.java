package wypozyczalnia.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.CreateKompletRequest;
import wypozyczalnia.dto.KompletDTO;
import wypozyczalnia.dto.RentKompletRequest;
import wypozyczalnia.model.Komplet;
import wypozyczalnia.service.KompletService;

import java.util.List;

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
    public List<KompletDTO> rentKomplet(@RequestBody RentKompletRequest request){
        return kompletService.findAll();
    }


}
