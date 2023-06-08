package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    Map<UUID, Customer> customerMap;

    CustomerServiceImpl(){
        customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .customerName("Yevhenii Kolosenko")
                .id(UUID.randomUUID())
                .version("1")
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .build();

        Customer customer2 = Customer.builder()
                .customerName("Sergii Kartashov")
                .id(UUID.randomUUID())
                .version("2")
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .build();

        Customer customer3 = Customer.builder()
                .customerName("Andrii Zarichny")
                .id(UUID.randomUUID())
                .version("3")
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);

    }
    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }
}
