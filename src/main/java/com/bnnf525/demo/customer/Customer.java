package com.bnnf525.demo.customer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private long id;
    @Column(unique = true, name = "userName")
    private String userName;
    @Column(unique = true, name = "email")
    private String email;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "date_of_birth")
    private LocalDate dob;

    public Customer() {
    }

    public Customer(Long id, String userName, String email, String passwd, LocalDate dob) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passwd = passwd;
        this.dob = dob;
    }

    public Customer(String userName, String email, String passwd, LocalDate dob) {
        this.userName = userName;
        this.email = email;
        this.passwd = passwd;
        this.dob = dob;
    }

    interface CustomerResponse{
        String getId();
        String getUserName();
        String getEmail();
        String getDob();
    }
}
