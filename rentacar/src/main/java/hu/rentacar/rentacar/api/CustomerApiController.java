
package hu.rentacar.rentacar.api;

import hu.rentacar.rentacar.annotation.Role;
import hu.rentacar.rentacar.model.Customer;
import static hu.rentacar.rentacar.model.Customer.Role.*;
import hu.rentacar.rentacar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/user") 
public class CustomerApiController {
    private final CustomerService customerService;
    
    @Autowired 
    public CustomerApiController(CustomerService customerService){
        this.customerService = customerService;
    }
    
    @Role({CUSTOMER, ADMIN})
    @GetMapping
    public ResponseEntity<Customer> customer() { 
        if (customerService.isLoggedIn()) { 
            return ResponseEntity.ok(customerService.getCustomer()); 
        } 
        return ResponseEntity.badRequest().build(); 
    } 
    
    
    
}


