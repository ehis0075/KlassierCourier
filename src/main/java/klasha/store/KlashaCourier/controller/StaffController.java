package klasha.store.KlashaCourier.controller;

import klasha.store.KlashaCourier.dto.StaffRegistrationdto;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Staff;
import klasha.store.KlashaCourier.service.CustomerService;
import klasha.store.KlashaCourier.service.StaffService;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import klasha.store.KlashaCourier.service.exception.StaffAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("api/staff")
@Slf4j
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping("/registration")
    ResponseEntity<?> registration(@RequestBody Staff registrationDto){

        try {
            staffService.create_account(registrationDto);
        } catch (StaffAlreadyExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok().body("registration successful");
    }



}
