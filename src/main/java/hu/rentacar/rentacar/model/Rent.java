package hu.rentacar.rentacar.model;

import com.fasterxml.jackson.annotation.*;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "RENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rent extends BaseEntity {
       
    @JoinColumn
    @ManyToOne(targetEntity = Customer.class, optional = false)
    private Customer customer;
    
    @JoinColumn
    @ManyToOne(targetEntity = Car.class, optional = false)
    private Car car;
    
    @JoinColumn
    @ManyToOne(targetEntity = RentalStatus.class)
    private RentalStatus rentalstatus;
        
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
    
    
    @Column(name = "price", nullable = false)
    private Integer price;
    
    
}
