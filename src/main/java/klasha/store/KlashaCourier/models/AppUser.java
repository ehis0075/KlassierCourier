package klasha.store.KlashaCourier.models;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RestResource(exported = false)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Role> roles;

    // for email verification
    private Boolean isVerified = Boolean.TRUE;

    public void addRole(Role userRole){

        if (roles == null){
            this.roles = new ArrayList<>();
        }
        this.roles.add(userRole);
    }

}
