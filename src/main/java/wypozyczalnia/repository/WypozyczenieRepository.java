package wypozyczalnia.repository;

import wypozyczalnia.model.Komplet;
import wypozyczalnia.model.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie, Long> {
   // private boolean isRented(Komplet komplet) {
     //   for (Wypozyczenie wypozyczenie : komplet.getWypozyczenie()){
       //     if (wypozyczenie.get...++null){
         //       return true;
           // }
       // }
       // return false;
  //  }
    //LocalDateTime now = LocalDateTime.now();
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM--dd HH:mm");
    //String formatDateTime = now.format(formatter);

}
