
package hu.rentacar.rentacar.repository;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.model.Rent;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Long>{
    
    Iterable<Car> findAllByRents(Rent rent);
    
    
    
}
