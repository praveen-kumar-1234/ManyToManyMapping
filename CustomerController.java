package com.praveen.controller;

import com.praveen.entity.Customer;
import com.praveen.model.CustomerModel;
import com.praveen.model.ProductModel;
import com.praveen.repo.CustomerRepo;
import com.praveen.service.CustomerService;
import com.praveen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manyToMany")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public Long customerID=0L;
    public Long productID=0L;
    @RequestMapping("/")
    public String home()
    {
        return "first";
    }

    @GetMapping("/addCustomer")
    public String customerForm(ModelMap model)
    {
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "addCustomer";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute CustomerModel customerModel,ModelMap model)
    {
        if(customerModel == null)
        {
            return "null";
        }
        model.addAttribute("message",customerService.saveCustomer(customerModel));
        model.addAttribute("customerList",customerService.fetchAll());
        return "next";
    }

    @GetMapping("/viewCustomer")
    public String viewCart(Model model){
        model.addAttribute("customerList",customerService.fetchAll());
        return "next";
    }


    @GetMapping("/AddProducts")
    public String addProducts(@RequestParam("customerId") Long customerId, Model model)
    {
        customerID = customerId;
        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel",productModel);
        return "addProduct";
    }


    @PostMapping("/saveProducts")
    public String saveProducts(@ModelAttribute("productModel") ProductModel productModel,Model model){
        model.addAttribute("message",customerService.saveProducts(productModel,customerID));
        return "first";
    }


    @GetMapping("/viewCustomerProducts")
    public String viewAllCustomerProducts(@RequestParam long customerId, Model model){
        model.addAttribute("CarDelarsList",customerService.customerDealers());
        return "customerProducts";
    }

    @RequestMapping("/deleteCustomer")
    public String delete(@RequestParam long customerId)
    {
        customerService.deleteCustomer(customerId);
        return "redirect:/viewCustomer";
    }

    @RequestMapping("/editCustomer")
    public String edit(@RequestParam long customerId,ModelMap model)
    {
        model.put("command",customerService.getCustomer(customerId));
        return "editCustomer";
    }

    @RequestMapping("/editandsave")
    public String editAndSave(Customer customer)
    {
        Customer edit = customerService.updateCustomer(customer);
        return "redirect:/viewCustomer";
    }




}
