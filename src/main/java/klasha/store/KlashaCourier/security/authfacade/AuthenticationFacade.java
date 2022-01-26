package klasha.store.KlashaCourier.security.authfacade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();
}
