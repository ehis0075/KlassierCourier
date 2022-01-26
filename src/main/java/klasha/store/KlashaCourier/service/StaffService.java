package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.StaffRegistrationdto;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Staff;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import klasha.store.KlashaCourier.service.exception.StaffAlreadyExistException;

public interface StaffService {

    void create_account(Staff registrationDto) throws StaffAlreadyExistException;

}
