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
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author szotyi
 */
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

    public Rent update(long id, Rent rent) { 
        Rent currentRent = rentRepository.findOne(id); 
        return rentRepository.save(rent); 
    } 


    public void delete(long id) { 
        rentRepository.delete(id); 
    } 

    public Rent read(long id) { 
        return rentRepository.findOne(id); 
    } 

    public Rent create(Rent rent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
