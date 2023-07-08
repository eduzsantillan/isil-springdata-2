package com.isil.springdatajpa.repository;

import com.isil.springdatajpa.entity.Customer;
import com.isil.springdatajpa.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    public List<Customer> findAllByFirstNameContaining(String character);

    @Procedure("CalculateAge")
    public int getAge(int birthYear);

}
