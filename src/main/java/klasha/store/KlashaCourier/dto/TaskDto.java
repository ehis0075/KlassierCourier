package klasha.store.KlashaCourier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

//    private PickUpDto pickUpDetailsDto;
//
//    private DeliveryDto deliveryTaskDto;
    private String senderFirstName;

    private String senderLastName;

    private String senderPhoneNumber;

    private String senderAddress;

    private String receiverFirstName;

    private String receiverLastName;

    private String receiverPhoneNumber;

    private String receiverAddress;

    private String scheduleType;
}
