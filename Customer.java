package com.praveen.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CUSTOMER_TABLE")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;
    private String customerName;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="CUSTOMER_PRODUCT_TABLE",joinColumns = {
            @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    },
    inverseJoinColumns = {
            @JoinColumn(name="product_id",referencedColumnName = "productId")
    })
    private Set<Product> products=new HashSet<>();

    public Customer(Long customerId, String customerName, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
