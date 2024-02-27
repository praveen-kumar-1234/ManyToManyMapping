package com.praveen;

import com.praveen.entity.Customer;
import com.praveen.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ManyToManyMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyMappingApplication.class, args);
//        Customer customer1=new Customer();
//        customer1.setCustomerName("praveen");
//        customer1.setEmail("praveen@gmail.com");
//
//
//        Customer customer2=new Customer();
//        customer2.setCustomerName("sravya");
//        customer2.setEmail("sravya@gmail.com");
//
//        Customer customer3=new Customer();
//        customer3.setCustomerName("suman");
//        customer3.setEmail("suman@gmail.com");
//
//
//
//
//        Set<Product> productSet1 = new HashSet<>();
//        Set<Product> productSet2 = new HashSet<>();
//
//        Set<Customer> customerSet1 = new HashSet<>();
//        Set<Customer> customerSet2 = new HashSet<>();
//
//
//        Product product1= new Product();
//        product1.setProductName("laptop");
//        product1.setDept("dell");
//        product1.setPrice(20000.00);
//
//        Product product2= new Product();
//        product2.setProductName("miniLaptop");
//        product2.setDept("lenovo");
//        product2.setPrice(40000.00);
//
//
//        Product product3= new Product();
//        product3.setProductName("computer");
//        product3.setDept("hp");
//        product3.setPrice(50000.00);
//
//
    }

}
