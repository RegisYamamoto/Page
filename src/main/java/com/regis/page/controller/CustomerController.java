package com.regis.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.regis.page.model.Customer;
import com.regis.page.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	
	// Acessar com http://localhost:8080/customers/search?searchTerm=james
    @GetMapping("/search")
    public Page<Customer> search(
            @RequestParam("searchTerm") String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return customerService.search(searchTerm, page, size);

    }

    @GetMapping
    public Page<Customer> getAll() {
        return customerService.findAll();
    }
	
}