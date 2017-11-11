
package hu.rentacar.rentacar.repository;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    
    Iterable<Rent> findAllByCustomer(Customer customer);
    Iterable<Rent> findAllByCar(Car car);

    
    
    
}
