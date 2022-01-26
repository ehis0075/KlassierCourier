package klasha.store.KlashaCourier.security.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import klasha.store.KlashaCourier.dto.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

/**
 * @author oluwatobi
 * @version 1.0
 * @date on 25/11/2021
 * inside the package - com.project.yconnector.security.exceptions
 */

@Slf4j
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */

    private final JsonObject jsonObjectImpl = new JsonObject();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.info("Authentication handler returning response");

            response.setStatus(HttpStatus.UNAUTHORIZED.value());

        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNAUTHORIZED, exception.getMessage(),
            exception.getMessage(), Calendar.getInstance().getTime().toString());


        OutputStream out = response.getOutputStream();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, errorDetails);
        out.flush();
        out.close();
    }
}
