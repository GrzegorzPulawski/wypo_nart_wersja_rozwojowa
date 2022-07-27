package repository;

import model.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie, Long> {
}
