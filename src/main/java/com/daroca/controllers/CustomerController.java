package com.daroca.controllers;

import com.daroca.models.Customer;
import com.daroca.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public List<Customer> getAll(){
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @PutMapping
    public Customer update(@RequestBody Customer newCustomer, @PathVariable Integer id){
        Optional<Customer> oldCustomer = repository.findById(id);
        if (oldCustomer.isPresent()){
            Customer c = oldCustomer.get();
            c.setName(newCustomer.getName());
            c.setEmail(newCustomer.getEmail());
            c.setLatitude(newCustomer.getLatitude());
            c.setLongitude(newCustomer.getLongitude());
            repository.save(c);
        }
    }



}
