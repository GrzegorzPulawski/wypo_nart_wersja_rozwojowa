package repository;

import model.Narty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NartyRepository extends JpaRepository<Narty, Long> {
}
