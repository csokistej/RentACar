/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rentacar.rentacar.service;

import hu.rentacar.rentacar.exception.CustomerNotValidException;
import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.repository.CustomerRepository;
import javassist.NotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    private Customer customer;
        
    public Customer login(Customer user) throws NotFoundException {
        if (isValid(user)) {
            return this.customer = customerRepository.findByUserName(user.getUserName()).get();
        }
        throw new NotFoundException("Invalid Customer");
    }

    public void logout() { 
        customer = null; 
    } 

    public Customer register(Customer user) {
        return this.customer = customerRepository.save(user);
    }

    public boolean isValid(Customer user) {
        System.out.println(user.getUserName());
        return customerRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()).isPresent();
    }
    
    public boolean isLoggedIn() {
        return customer != null;
    }
    
    public Customer getLoggedInUser() { 
        return customer; 
    } 
    
    
    
}
