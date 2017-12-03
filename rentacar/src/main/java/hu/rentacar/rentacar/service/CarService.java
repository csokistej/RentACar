package hu.rentacar.rentacar.service;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author kgergely
 */

@Service
@SessionScope
@Data
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAllCar(){
        List<Car> result = new ArrayList<>();
        carRepository.findAll().forEach(result::add);
        return result;
    }

    public Car getCarById(String id) throws NotFoundException{
        Long carId = Long.parseLong(id);
        Optional<Car> car = carRepository.findById(carId);
        if(car.isPresent()){
            return car.get();
        }
        throw new NotFoundException("Invalid Car Id!");
    }
}
