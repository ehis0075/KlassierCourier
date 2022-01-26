package klasha.store.KlashaCourier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private PickUpDto pickUpDetailsDto;

    private DeliveryDto deliveryTaskDto;

    private String scheduleType;
}
