package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Narty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.NartyRepository;
import service.NartyService;

@Slf4j
@RequestMapping("/api/narty")
@RestController
@RequiredArgsConstructor
public class NartyController {
    private final NartyService nartyService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNarty(@RequestBody Narty narty){
        log.info("Request create ->" + narty);
        nartyService.addNarty(narty);
    }

}
