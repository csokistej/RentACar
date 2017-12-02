package hu.rentacar.rentacar.controller;

import hu.rentacar.rentacar.service.RentService;
import hu.rentacar.rentacar.model.Rent;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kgergely
 */

@RestController
@RequestMapping("/rent")
public class RentController {
    
    private static final String ID = "{id}";
    
    @Autowired
    private RentService rentService;
    
    @GetMapping("/rents")
    public List<Rent> getRents(){
        return rentService.getAllRent();
    }
    
    @GetMapping(ID)
    public Rent getRentById(String id) throws NotFoundException {
        return rentService.read(id);
    }
    
    @PostMapping("/add")
    public Rent addRent(@RequestBody Rent rent){
        return rentService.create(rent);
    }
}
