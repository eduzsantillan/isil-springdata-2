package com.isil.springdatajpa.repository;

import com.isil.springdatajpa.entity.ItemOrder;
import com.isil.springdatajpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Long> {
}
