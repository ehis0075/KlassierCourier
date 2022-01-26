package klasha.store.KlashaCourier.service;



import klasha.store.KlashaCourier.models.AppUser;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Role;
import klasha.store.KlashaCourier.repository.AppUserRepository;
import klasha.store.KlashaCourier.repository.CustomerRepository;
import klasha.store.KlashaCourier.security.authfacade.AuthenticationFacade;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public void create_account(Customer registrationDto) throws CustomerAlreadyExistException {

        log.info("Customer registration request ---> {}", registrationDto);

        if(customerRepository.findByEmail(registrationDto.getEmail()) == null){

            log.info("Customer is not registered ");

            AppUser appUser = new AppUser();
            appUser.setEmail(registrationDto.getEmail());
            appUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            appUser.addRole(Role.CUSTOMER);
            appUser.setIsVerified(true);

            appUserRepository.save(appUser);

            log.info("App user saved ---> {}", appUser);

            registrationDto.setAppUser(appUser);
            registrationDto.setPassword(appUser.getPassword());

            log.info("Customer before saving --> {}", registrationDto);

            customerRepository.save(registrationDto);

            log.info("After saving customer details to db --->{}", registrationDto);

            //send verification token to email

        } else {
            throw new CustomerAlreadyExistException("a customer with email "+ registrationDto.getEmail() +" already exist!");
        }

    }

//    @Override
//    public Customer getLoggedInUser() {
//
//        String name = authenticationFacade.getAuthentication().getName();
//        log.info("Authentication facade --> {}", name);
//
//        return customerRepository.findByEmail(name);
//    }


}
