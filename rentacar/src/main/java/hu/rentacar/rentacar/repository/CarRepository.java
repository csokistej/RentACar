package hu.rentacar.rentacar.repository;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car, Long>{
    
    Iterable<Car> findAllByRents(Rent rent);
    
    Optional<Car> findByCarType(String carType);
    
    Optional<Car> findById(Long id);
}
