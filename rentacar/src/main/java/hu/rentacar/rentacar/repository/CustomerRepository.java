
package hu.rentacar.rentacar.repository;

import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.model.Rent;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByUserName(String userName);

    Optional<Customer> findByUserNameAndPassword(String userName, String password);
    
    Iterable<Customer> findAllByRents(Rent rent);
    
    
}
