package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity addNewCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.addCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer/" + savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Customer> getCustomers(){
    return customerService.getCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    Customer getCustomerById(@PathVariable UUID customerId){
        return customerService.getCustomerById(customerId);
    }
}
