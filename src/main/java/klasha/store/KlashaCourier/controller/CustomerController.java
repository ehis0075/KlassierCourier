package klasha.store.KlashaCourier.controller;



import com.sun.istack.NotNull;
import klasha.store.KlashaCourier.dto.DeliveryDto;
import klasha.store.KlashaCourier.dto.TaskDto;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Task;
import klasha.store.KlashaCourier.service.CustomerService;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.text.ParseException;


@RestController
@RequestMapping("api/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/registration")
    ResponseEntity<?> registration(@RequestBody Customer registrationDto){

        try {
            customerService.create_account(registrationDto);
        } catch (CustomerAlreadyExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok().body("registration successful");
    }

    @GetMapping("/get-logged-in-customer")
    public ResponseEntity<Customer> getLoggedInUser(){

        log.info("Get logged in user called");
        Customer customer = customerService.getLoggedInUser();

        log.info("Object found --> {}", customer);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/place-order")
    ResponseEntity<?> placeOrder(@RequestBody @NotNull TaskDto taskDto){

        try {
            customerService.placeOrder(taskDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok().body("successful order ");

    }

}
