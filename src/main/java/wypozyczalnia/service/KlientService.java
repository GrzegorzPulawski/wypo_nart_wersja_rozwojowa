package wypozyczalnia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wypozyczalnia.dto.CreateKlientRequest;
import wypozyczalnia.dto.KlientDTO;
import wypozyczalnia.model.Klient;
import wypozyczalnia.repository.KlientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class KlientService {
    private final KlientRepository klientRepository;

    public void add(String nrTelefonu, CreateKlientRequest klientRequest){



         }

    }
}
