package klasha.store.KlashaCourier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {

    private String address;

    private String firstName;

    private String lastName;

    private String phoneNumber;

}
