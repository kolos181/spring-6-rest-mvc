package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public interface CustomerService {
    Collection<Customer> getCustomers();
    Customer getCustomerById(UUID id);

    Customer addCustomer(Customer customer);
}
