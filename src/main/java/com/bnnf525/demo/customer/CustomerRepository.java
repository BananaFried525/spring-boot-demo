package com.bnnf525.demo.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.userName = :userName or c.email = :email or (c.userName like %:option% or c.email like %:option% ) order by c.id asc")
    List<Customer> findAllByOption(
        @Param(value = "userName") String userName, 
        @Param(value = "email") String email,
        @Param(value = "option") String option);
}
