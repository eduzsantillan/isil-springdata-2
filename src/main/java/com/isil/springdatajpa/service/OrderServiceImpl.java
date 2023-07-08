package com.isil.springdatajpa.service;

import com.isil.springdatajpa.entity.Customer;
import com.isil.springdatajpa.entity.Order;
import com.isil.springdatajpa.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{

    private final OrderRepository orderRepository;
    private final ICustomerService customerService;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> get() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> getByCustomer(Long idCustomer){
        return orderRepository.findAllByCustomer(customerService.getCustomer(idCustomer));
    }
}
