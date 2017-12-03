
package hu.rentacar.rentacar.model;

import com.fasterxml.jackson.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "RENTAL_STATUS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RentalStatus extends BaseEntity {
 
    @OneToMany(targetEntity = Rent.class, mappedBy = "rentalstatus")
//    @OneToMany(targetEntity = Rent.class, mappedBy = "rentalstatus", cascade = CascadeType.ALL) 
    @JsonIgnoreProperties("rentalstatus") 
    @JsonIgnore
    private List<Rent> rent;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    
}
