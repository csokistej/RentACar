/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rentacar.rentacar.service;

import hu.rentacar.rentacar.exception.CustomerNotValidException;
import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javassist.NotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import static java.util.stream.Collectors.toList;

@Service
@SessionScope
@Data
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    private Customer customer;
    
    //ToDo: Where is rents from the return value
    public Customer login(Customer user) throws NotFoundException {
        if (isValid(user)) {
            return this.customer = customerRepository.findByUserName(user.getUserName()).get();
        }
        throw new NotFoundException("Invalid Customer");
    }

    public Customer logout(Customer user) throws NotFoundException {
        if (isValid(user)) {
            customer = null;
        }
        throw new NotFoundException("Invalid Customer");
    } 

    public Customer register(Customer user) {
        return this.customer = customerRepository.save(user);
    }

    public boolean isValid(Customer user) {
        return customerRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()).isPresent();
    }
    
    public boolean isLoggedIn() {
        return customer != null;
    }
    
    public Customer getLoggedInCustomers() { 
        return customer; 
    }
    
    public List<Customer> getAllCustomer(){
        List<Customer> result = new ArrayList<>();
        customerRepository.findAll().forEach(result::add);
        result.forEach(c -> c.setPassword(null));
        return result;
    }
    
    public Customer update(Customer newCustomer) {
        Customer customeR = customerRepository.findByUserName(newCustomer.getUserName()).get(); //ToDo if empty the Optional
        copyToEntity(newCustomer, customer);
        return this.customer = customerRepository.save(customer);
    }
    
    private void copyToEntity(Customer newCustomer, Customer oldCustomer){
        oldCustomer.setPassword(newCustomer.getPassword());
        oldCustomer.setAccountNumber(newCustomer.getAccountNumber());
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setDrivingLicense(newCustomer.getDrivingLicense());
        oldCustomer.setEmail(newCustomer.getEmail());
        oldCustomer.setFullName(newCustomer.getFullName());
        oldCustomer.setRents(newCustomer.getRents());
    }
}
