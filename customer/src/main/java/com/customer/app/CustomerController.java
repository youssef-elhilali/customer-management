package com.customer.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers () {
        return this.customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer (@RequestBody CustomerDto customerDto) {
        return this.customerService.saveCustomer(customerDto);
    }
}
