package klasha.store.KlashaCourier.repository;

import klasha.store.KlashaCourier.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    List<Customer> findByDateCreated(LocalDate date);

}
