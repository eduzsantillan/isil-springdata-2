package com.isil.springdatajpa.repository;

import com.isil.springdatajpa.entity.Customer;
import com.isil.springdatajpa.entity.Order;
import com.isil.springdatajpa.entity.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select o from Order o where o.customer = :customer order by o.description desc")
    public List<Order> findAllByCustomer(Customer customer);

    public List<Order> findAllByCustomerOrderByDescriptionDesc(Customer customer);


}
