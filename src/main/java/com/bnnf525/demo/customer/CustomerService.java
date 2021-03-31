package com.bnnf525.demo.customer;

import java.util.List;
import java.util.Optional;

import com.bnnf525.demo.customer.Customer.CustomerResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerByOption(String userName, String email, String option) {
        return customerRepository.findAllByOption(userName, email, option);
    }

    public void postCustomer(Customer customer) throws Exception {
        Customer _customer = customerRepository.save(customer);
        log.info("Customer", _customer.toString());
    }

    public void deleteCustomer(Long id) throws Exception {
        customerRepository.deleteById(id);
    }

    public void putCustomer(Long id, Customer customer) throws Exception {
        customerRepository.save(customer);
    }
}
