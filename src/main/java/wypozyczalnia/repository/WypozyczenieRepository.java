package wypozyczalnia.repository;

import wypozyczalnia.model.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie, Long> {
}
