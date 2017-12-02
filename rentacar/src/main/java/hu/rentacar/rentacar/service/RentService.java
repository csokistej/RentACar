/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rentacar.rentacar.service;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.model.Rent;
import hu.rentacar.rentacar.repository.RentRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javassist.NotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author szotyi
 */
@Service
@SessionScope
@Data
public class RentService {
    
    @Autowired 
    private RentRepository rentRepository; 
   
    public Iterable<Rent> listByCustomer(Customer customer) { 
        if (customer != null) { 
            return rentRepository.findAllByCustomer(customer); 
        }  
        return Collections.emptyList(); 
    } 

    public Rent create(Rent rent, Customer customer, Car car) { 
//        RentalStatus status = new RentalStatus();
//        status.setStatus(Status.AVAILABLE);
//        rent.setStatus(status);
        rent.setCustomer(customer); 
        rent.setCar(car);
        return rentRepository.save(rent); 
    }
    public Rent create(Rent rent) {
        return rentRepository.save(rent); 
    }

    //Should we update a Rent?
    public Rent update(long id, Rent rent) { 
        Rent currentRent = rentRepository.findOne(id); 
        return rentRepository.save(rent); 
    } 


    public void delete(long id) { 
        rentRepository.delete(id); 
    } 

    public Rent read(String id)  throws NotFoundException { 
        Long rentId = Long.parseLong(id);
        Rent rent = rentRepository.findOne(rentId);
        if(rent != null){
            return rent;
        }
        throw new NotFoundException("Invalid Car Id!");
    }
    
    public List<Rent> getAllRent(){
        List<Rent> result = new ArrayList<>();
        rentRepository.findAll().forEach(result::add);
        return result;
    }
}
