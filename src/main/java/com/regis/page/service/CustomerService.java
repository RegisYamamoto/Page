package com.regis.page.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.regis.page.model.Customer;
import com.regis.page.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");

        return customerRepository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }

    public Page<Customer> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
        		customerRepository.findAll(), 
                pageRequest, size);
    }
	
}