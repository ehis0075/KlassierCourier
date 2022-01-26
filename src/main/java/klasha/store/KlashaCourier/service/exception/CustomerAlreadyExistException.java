package klasha.store.KlashaCourier.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException {

    public CustomerAlreadyExistException() {
        super();
    }
    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
    public CustomerAlreadyExistException(Throwable cause) {
        super(cause);
    }

}
