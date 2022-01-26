package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.StaffRegistrationdto;
import klasha.store.KlashaCourier.models.AppUser;
import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Role;
import klasha.store.KlashaCourier.models.Staff;
import klasha.store.KlashaCourier.repository.AppUserRepository;
import klasha.store.KlashaCourier.repository.CustomerRepository;
import klasha.store.KlashaCourier.repository.StaffRepository;
import klasha.store.KlashaCourier.security.authfacade.AuthenticationFacade;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import klasha.store.KlashaCourier.service.exception.StaffAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class StaffServiceImpl implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Autowired
    AppUserRepository appUserRepository;



    @Override
    public void create_account(Staff registrationDto) throws StaffAlreadyExistException {

        log.info("staff registration request ---> {}", registrationDto);

        if(staffRepository.findByEmail(registrationDto.getEmail()) == null){

            log.info("Staff is not registered ");

            AppUser appUser = new AppUser();
            appUser.setEmail(registrationDto.getEmail());
            appUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            appUser.addRole(Role.STAFF);
            appUser.setIsVerified(true);

            appUserRepository.save(appUser);

            log.info("App user saved ---> {}", appUser);

            registrationDto.setAppUser(appUser);
            registrationDto.setPassword(appUser.getPassword());

            log.info("Staff before saving --> {}", registrationDto);

            staffRepository.save(registrationDto);

            log.info("After saving staff details to db --->{}", registrationDto);


        } else {
            throw new CustomerAlreadyExistException("a staff with email "+ registrationDto.getEmail() +" already exist!");
        }

    }

}
