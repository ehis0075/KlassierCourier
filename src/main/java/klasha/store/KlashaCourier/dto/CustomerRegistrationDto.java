package klasha.store.KlashaCourier.dto;


import klasha.store.KlashaCourier.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private AppUser appUser;
}
