package klasha.store.KlashaCourier.repository;


import klasha.store.KlashaCourier.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByEmail(String email);

}