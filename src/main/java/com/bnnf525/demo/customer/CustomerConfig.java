package com.bnnf525.demo.customer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer Athm = new Customer("Athm","Athm","Athm",LocalDate.of(1998,1,1));
            Customer Bthm = new Customer("Bthm","Bthm","Bthm",LocalDate.of(1998,2,2));

            customerRepository.saveAll(List.of(Athm, Bthm));
        };
    }
}
