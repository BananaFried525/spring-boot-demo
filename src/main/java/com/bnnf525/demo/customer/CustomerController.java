package com.bnnf525.demo.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import com.bnnf525.demo.FormatResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    public FormatResponse getCustomer(@RequestParam(required = false, defaultValue = "") String userName,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String option) {
        List<Customer> retGet = customerService.getCustomerByOption(userName, email, option);
        return new FormatResponse("Success", 200, retGet);
    }

    @PostMapping(value = "")
    public FormatResponse postCustomer(@RequestBody Customer customer) {
        try {
            customerService.postCustomer(customer);
            return new FormatResponse("Success", 200, "");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new FormatResponse("fail", 403, "");
        }
    }

    @DeleteMapping
    public FormatResponse deleteCustomer(@RequestParam() Long id) {
        try {
            customerService.deleteCustomer(id);
            return new FormatResponse("Success", 200, "");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new FormatResponse("fail", 403, "");
        }
    }

    @PutMapping
    public FormatResponse postCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        try {
            if(id != customer.getId()){
                return new FormatResponse("fail", 403, "");
            }
            customerService.putCustomer(id, customer);
            return new FormatResponse("Success", 200, "");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new FormatResponse("fail", 403, "");
        }
    }
}
