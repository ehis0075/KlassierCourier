package klasha.store.KlashaCourier.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 23444536367737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PickUpDetails pickUpDetails;

    @OneToOne
    private DeliveryDetails deliveryDetails;

    private ScheduleType scheduleType;

}
