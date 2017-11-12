package hu.rentacar.rentacar.controller;

import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.service.CustomerService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author szotyi
 * @author kgergely
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    CustomerService service; 
    
    //This is a bit dangerous endpoint!!!
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return service.getAllCustomer();
    }
    
    @GetMapping("/logged")
    public Customer getLoggedInCustomers(){
        return service.getLoggedInCustomers();
    }
    
    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody Customer customer) throws NotFoundException {
        return service.login(customer);
    }
    
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer){
        return service.register(customer);
    }
    
    @PostMapping("/logout")
    public Customer logoutCustomer(@RequestBody Customer customer) throws NotFoundException {
        return service.logout(customer);
    }
    
    @PostMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return service.update(customer);
    }
}
