package com.isil.springdatajpa.api;

import com.isil.springdatajpa.dto.CustomerDTO;
import com.isil.springdatajpa.entity.Customer;
import com.isil.springdatajpa.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerHandler {

    private final ICustomerService customerService;

    @GetMapping ({"","/"})
    public ResponseEntity<List<CustomerDTO>> get(){
        return ResponseEntity.ok().body(customerService.get());
    }

    @GetMapping("/{varChar}")
    public ResponseEntity<List<Customer>> getByChar(@PathVariable String varChar){
        return ResponseEntity.ok().body(customerService.getCustomerByCharacter(varChar));
    }

    @GetMapping("/getage/{birthYear}")
    public ResponseEntity<HashMap<String,String>> getAge(@PathVariable int birthYear){
        HashMap<String,String> response = new HashMap<>();
        response.put("Edad", String.valueOf(customerService.getAge(birthYear)));
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add")
    public ResponseEntity<HashMap<String,String>> add (@RequestBody CustomerDTO dto){
        HashMap<String,String> response = new HashMap<>();
        customerService.save(dto);
        response.put("Resultado","Cliente registrado");
        return ResponseEntity.ok().body(response);
    }

}
