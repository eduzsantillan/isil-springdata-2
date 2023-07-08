package com.isil.springdatajpa.service;

import com.isil.springdatajpa.dto.CustomerDTO;
import com.isil.springdatajpa.entity.Customer;
import com.isil.springdatajpa.exception.CanalNotFoundException;
import com.isil.springdatajpa.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService{

    private final CustomerRepository customerRepository;


    @Override
    public void save(CustomerDTO dto) {
        if(dto.getCanal().isEmpty()){
            throw new CanalNotFoundException();
        }
        Customer customerToSave = new Customer();
        customerToSave.setFirstName(dto.getFisrtName());
        customerToSave.setLastName(dto.getLastName());
        customerToSave.setEmail(dto.getCorreo());
        customerRepository.save(customerToSave);
    }

    @Override
    public List<CustomerDTO> get() {
        return customerRepository.findAll()
                .stream()
                .map(item -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setFisrtName(item.getFirstName());
                    customerDTO.setLastName(item.getLastName());
                    customerDTO.setCorreo(item.getEmail());
                    customerDTO.setCode("1");
                    customerDTO.setMensaje("Usuario agregado");
                    return customerDTO;
                })
                .toList();
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getCustomerByCharacter(String character) {
        return customerRepository.findAllByFirstNameContaining(character);
    }

    @Override
    public int getAge(int birthYear){
        return customerRepository.getAge(birthYear);
    }
}
