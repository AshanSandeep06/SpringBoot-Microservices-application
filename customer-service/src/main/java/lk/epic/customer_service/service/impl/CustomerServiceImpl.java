package lk.epic.customer_service.service.impl;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.customer_service.entity.Customer;
import lk.epic.customer_service.repo.CustomerRepo;
import lk.epic.customer_service.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
// We can inject CustomerRepo interface's bean just like this
// We don't need @Autowired annotation for that
// Because we're using a record
public record CustomerServiceImpl(CustomerRepo customerRepo) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequestDTO registrationRequest) {
        Customer customer = Customer.builder()
                .name(registrationRequest.name())
                .address(registrationRequest.address())
                .email(registrationRequest.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: store customer in db
        customerRepo.save(customer);
    }
}
