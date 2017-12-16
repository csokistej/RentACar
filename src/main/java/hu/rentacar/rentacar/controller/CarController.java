package hu.rentacar.rentacar.controller;

import hu.rentacar.rentacar.model.Car;
import hu.rentacar.rentacar.service.CarService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kgergely
 */

@RestController
@RequestMapping("api/car")
public class CarController {
    
    @Autowired
    private CarService carService;
    
    private static final String ID = "{id}";
    
    @GetMapping("/all")
    public List<Car> getAllCar(){
        return carService.getAllCar();
    }
    
    @GetMapping(ID)
    public Car getCarById(@PathVariable String id) throws NotFoundException {
        return carService.getCarById(id);
    }
}
