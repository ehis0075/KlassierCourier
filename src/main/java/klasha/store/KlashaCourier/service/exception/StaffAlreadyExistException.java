package klasha.store.KlashaCourier.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StaffAlreadyExistException extends RuntimeException {

    public StaffAlreadyExistException() {
        super();
    }
    public StaffAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public StaffAlreadyExistException(String message) {
        super(message);
    }
    public StaffAlreadyExistException(Throwable cause) {
        super(cause);
    }

}
