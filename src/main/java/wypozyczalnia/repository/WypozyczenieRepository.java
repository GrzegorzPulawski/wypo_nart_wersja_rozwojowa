package wypozyczalnia.repository;

import wypozyczalnia.model.Komplet;
import wypozyczalnia.model.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie, Long> {
   // private boolean isRented(Komplet komplet) {
     //   for (Wypozyczenie wypozyczenie : komplet.getWypozyczenie()){
       //     if (wypozyczenie.get...++null){
         //       return true;
           // }
       // }
       // return false;
  //  }

}
