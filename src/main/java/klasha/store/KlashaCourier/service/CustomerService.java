package klasha.store.KlashaCourier.service;


import klasha.store.KlashaCourier.dto.TaskDto;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Task;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;


public interface CustomerService {

    void create_account(Customer registrationDto) throws CustomerAlreadyExistException;

    public Customer getLoggedInUser();

    void placeOrder(TaskDto taskDto);

    // create order

}
