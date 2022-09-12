package wypozyczalnia.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wypozyczalnia.dto.ButyDTO;
import wypozyczalnia.dto.CreateButyRequest;
import wypozyczalnia.service.ButyService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/buty")
@RequiredArgsConstructor
public class ButyController {
    private final ButyService butyService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createButy(@RequestBody CreateButyRequest createButyRequest){
        log.info("Request create ->" + createButyRequest);
        butyService.addButy(createButyRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ButyDTO> butyDTOList() {
        log.info("Request: list");
        return butyService.findAll();
    }
}
