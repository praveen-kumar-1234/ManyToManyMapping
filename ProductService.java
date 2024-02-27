package com.praveen.service;

import com.praveen.entity.Product;
import com.praveen.model.CustomerModel;
import com.praveen.model.ProductModel;

import java.util.List;

public interface ProductService {


    public String saveProduct(ProductModel productModel);

    public List<ProductModel> fetchAll();

    public String saveCustomers(CustomerModel customerModel, Long productId);

    public List<CustomerModel>  productDealers(long customerId);
    public void deleteProduct(Long productId);
    public Product getProduct(long productId);


    public Product updateProduct(Product product);
}
