package com.isil.springdatajpa.api;

import com.isil.springdatajpa.entity.Order;
import com.isil.springdatajpa.service.IOrderService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderHandler {

    private final IOrderService orderService;

     @GetMapping ({"","/"})
    public ResponseEntity<List<Order>> get (){
        return ResponseEntity.ok().body(orderService.get());
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Order>> getByCustomer (@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.getByCustomer(id));
    }
}
