package com.isil.springdatajpa.service;

import com.isil.springdatajpa.dto.CustomerDTO;
import com.isil.springdatajpa.entity.Customer;

import java.util.List;

public interface ICustomerService {

    public void save(CustomerDTO dto);
    public List<CustomerDTO> get();
    public void delete(Customer customer);

    public Customer getCustomer(Long id);

    public List<Customer> getCustomerByCharacter(String character);


    public int getAge(int birthYear);

}
