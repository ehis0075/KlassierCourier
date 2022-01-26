package klasha.store.KlashaCourier.repository;

import klasha.store.KlashaCourier.models.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Long> {
}
