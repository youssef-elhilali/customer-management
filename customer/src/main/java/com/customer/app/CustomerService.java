package com.customer.app;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    ResponseEntity<?> saveCustomer (CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
}
