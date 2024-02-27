package com.praveen.service;

import com.praveen.entity.Customer;
import com.praveen.entity.Product;
import com.praveen.model.CustomerModel;
import com.praveen.model.ProductModel;
import com.praveen.repo.CustomerRepo;
import com.praveen.repo.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImp implements CustomerService {


    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;


    public CustomerServiceImp(CustomerRepo customerRepo, ProductRepo productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public String saveCustomer(CustomerModel customerModel)
    {
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerModel,customer);
        customerRepo.save(customer);
        return "Data saved successfully";
    }


    public List<CustomerModel> fetchAll()
    {

        List<Customer> customerList = customerRepo.findAll();

        List<CustomerModel> customerModelList = new ArrayList<>();


        customerList.forEach(customer -> {
            CustomerModel customerModel=new CustomerModel();
            BeanUtils.copyProperties(customer,customerModel);
            customerModelList.add(customerModel);
        });

        return customerModelList;
    }

    public String saveProducts(ProductModel productModel, Long customerId){
        Product product=new Product();
        BeanUtils.copyProperties(productModel,product);//convert

        Customer customerEntity = customerRepo.findById(customerId).get();//customer entity
        Set<Product> productSet= new HashSet<>();
        productSet.addAll(customerEntity.getProducts());
        productSet.add(product);
        customerEntity.setProducts(productSet);
        productRepo.save(product);

//        customerEntity.setProducts(productSet);

//        Set<Customer> customerSet = product.getCustomer();
//        customerSet.add(customerEntity);
//
//        product.setCustomer(customerSet);
//
//        productSet.add(product);
//        customerRepo.save(customerEntity);
//        productRepo.save(product);
        return "Product saved Successfully";


    }



    public List<CustomerModel>  customerDealers(){
        List<Customer> customerList=customerRepo.findAll();
        List<CustomerModel> customerModelList=new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerModel customerModel=new CustomerModel();
            BeanUtils.copyProperties(customer,customerModel);
            customerModelList.add(customerModel);
        });
        return customerModelList;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepo.deleteById(customerId);
    }


    @Override
    public Customer getCustomer(long customerId) {
        Customer get = customerRepo.findById(customerId).get();
        return get;
    }

    public Customer updateCustomer(Customer customer)
    {
        Customer newRecord = new Customer();
        newRecord.setCustomerId(customer.getCustomerId());
        newRecord.setCustomerName(customer.getCustomerName());
        newRecord.setEmail(customer.getEmail());
        newRecord.setProducts(customer.getProducts());
        return customerRepo.save(customer);
    }




}
