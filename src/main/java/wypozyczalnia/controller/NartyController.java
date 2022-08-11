package wypozyczalnia.controller;

import wypozyczalnia.dto.CreateNartyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.NartyDTO;
import wypozyczalnia.service.NartyService;

import java.util.List;

@Slf4j
@RequestMapping("/api/narty")
@RestController
@RequiredArgsConstructor
public class NartyController {
    private final NartyService nartyService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNarty(@RequestBody CreateNartyRequest createNartyRequest){
        log.info("Request create ->" + createNartyRequest);
        nartyService.addNarty(createNartyRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<NartyDTO> nartyDTOList() {
        log.info("Request: list");
        return nartyService.findAll();
    }

}
