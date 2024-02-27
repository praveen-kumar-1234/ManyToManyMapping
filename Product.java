package com.praveen.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PRODUCT_TABLE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private String productName;
    private String dept;
    private double price;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="CUSTOMER_PRODUCT_TABLE",joinColumns = @JoinColumn(name="product_id",referencedColumnName = "productId"), inverseJoinColumns =
                    @JoinColumn(name="customer_id",referencedColumnName = "customerId"))

    private Set<Customer> customer=new HashSet<>();

    public Product(Long productId, String productName, String dept, double price) {
        this.productId = productId;
        this.productName = productName;
        this.dept = dept;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", dept='" + dept + '\'' +
                ", price=" + price +
                '}';
    }
}
