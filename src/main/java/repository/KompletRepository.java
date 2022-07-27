package repository;

import model.Komplet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KompletRepository extends JpaRepository<Komplet, Long> {
}
