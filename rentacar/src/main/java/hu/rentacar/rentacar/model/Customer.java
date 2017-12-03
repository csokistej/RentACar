
package hu.rentacar.rentacar.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOMERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
 
    
    @OneToMany(targetEntity = Rent.class, mappedBy = "customer")
    private List<Rent> rents;
    
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "fullname", nullable = false)
    private String fullName;
    
    @Column(name = "email", nullable = false)
    private String email;
            
    @Column(name = "address", nullable = false)
    private String address;
            
    @Column(name = "license", nullable = false, unique = true)
    private String drivingLicense;
     
    @Column(name = "accountnumber", nullable = false)
    private String accountNumber;
    
}
