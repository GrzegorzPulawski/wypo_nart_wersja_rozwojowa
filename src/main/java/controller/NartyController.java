package controller;

import dto.NartyDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Narty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.NartyService;

import java.util.List;

@Slf4j
@RequestMapping("/api")
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
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<NartyDTO> nartyDTOList() {
        log.info("Request: list");
        return nartyService.findAll();
    }

}
