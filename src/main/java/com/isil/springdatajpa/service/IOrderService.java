package com.isil.springdatajpa.service;

import com.isil.springdatajpa.entity.Order;

import java.util.List;

public interface IOrderService {

    public void save(Order order);
    public List<Order> get();
    public void delete(Order order);

    public List<Order> getByCustomer(Long id);

}
