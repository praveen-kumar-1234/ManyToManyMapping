package com.praveen.controller;

import com.praveen.entity.Customer;
import com.praveen.entity.Product;
import com.praveen.model.CustomerModel;
import com.praveen.model.ProductModel;
import com.praveen.service.CustomerService;
import com.praveen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productControl")
public class ProductController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;
    public Long customerID;
    public Long productID;

    @GetMapping("/addProduct")
    public String productForm(ModelMap model)
    {
        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel",productModel);
        return "addProduct1";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute ProductModel productModel,ModelMap model)
    {
        if(productModel == null)
        {
            return "null";
        }
        model.addAttribute("message",productService.saveProduct(productModel));
        model.addAttribute("productList",productService.fetchAll());
        return "next1";
    }



    @GetMapping("/viewProduct")
    public String viewProduct(Model model){
        model.addAttribute("productList",productService.fetchAll());
        return "next1";
    }


    @GetMapping("/AddCustomers")
    public String addCustomer(@RequestParam("productId") Long productId, Model model)
    {
        productID = productId;
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "addCustomer1";
    }



    @PostMapping("/saveCustomers")
    public String saveCustomers(@ModelAttribute("customerModel") CustomerModel customerModel,Model model){
        model.addAttribute("message",productService.saveCustomers(customerModel,productID));
        return "first";
    }


    @GetMapping("/viewProductCustomers")
    public String viewAllProductCustomers(@RequestParam long productId, Model model){
        System.out.println("popopop:-");
        model.addAttribute("CarDelarsList",productService.productDealers(productId));
        return "productCustomers";
    }

    @RequestMapping("/deleteProduct")
    public String delete(@RequestParam long productId)
    {
        productService.deleteProduct(productId);
        return "redirect:/productControl/viewProduct";
    }

    @RequestMapping("/editProduct")
    public String edit(@RequestParam long productId,ModelMap model)
    {
        model.put("command",productService.getProduct(productId));
        return "editProduct";
    }

    @RequestMapping("/editandsave")
    public String editAndSave(Product product)
    {
        Product edit = productService.updateProduct(product);
        return "redirect:/productControl/viewProduct";
    }





}
