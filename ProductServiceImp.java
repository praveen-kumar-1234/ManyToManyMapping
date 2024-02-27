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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImp implements  ProductService{


    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;


    public ProductServiceImp(CustomerRepo customerRepo, ProductRepo productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public String saveProduct(ProductModel productModel)
    {
        Product product=new Product();
        BeanUtils.copyProperties(productModel,product);
        productRepo.save(product);
        return "Data saved successfully";
    }

    public List<ProductModel> fetchAll()
    {

        List<Product> productList = productRepo.findAll();

        List<ProductModel> productModelList = new ArrayList<>();


        productList.forEach(product -> {
            ProductModel productModel=new ProductModel();
            BeanUtils.copyProperties(product,productModel);
            productModelList.add(productModel);
        });

        return productModelList;
    }

    @Override
    public String saveCustomers(CustomerModel customerModel, Long productId){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerModel,customer);//convert

        Product product1 = productRepo.findById(productId).get();//customer entity

        Set<Product> productSet = customer.getProducts();
        productSet.add(product1);

        customer.setProducts(productSet);

        Set<Customer> customerSet= new HashSet<>();
        customerSet.add(customer);

        product1.setCustomer(customerSet);

        customerRepo.save(customer);
        productRepo.save(product1);
//        productRepo.save(product);
        return "Customer saved Successfully";
    }


    public List<CustomerModel>  productDealers(long productId){

        Product product = productRepo.findById(productId).get();
        Set<Customer> customerList = product.getCustomer();
        List<CustomerModel> customers=new ArrayList<>();
        for(Customer cust:customerList)
        {
            CustomerModel customerModel = new CustomerModel();
            customerModel.setCustomerId(cust.getCustomerId());
            customerModel.setCustomerName(cust.getCustomerName());
            customerModel.setEmail(cust.getEmail());
            customerModel.setProducts(cust.getProducts());
            System.out.println("123:- "+ customerModel.getCustomerName());
        }

        return customers;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product getProduct(long productId) {
        Product get = productRepo.findById(productId).get();
        return get;
    }

    @Override
    public Product updateProduct(Product product)
    {
        Product newRecord = new Product();
        newRecord.setProductId(product.getProductId());
        newRecord.setProductName(product.getProductName());
        newRecord.setDept(product.getDept());
        newRecord.setPrice(product.getPrice());
        newRecord.setCustomer(product.getCustomer());
        return productRepo.save(product);
    }



}
