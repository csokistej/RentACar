
package hu.rentacar.rentacar.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import javax.persistence.*;
import lombok.*;



@Entity
@Table(name = "CAR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {
 
    
    @OneToMany(targetEntity = Rent.class, mappedBy = "car") 
    @JsonIgnoreProperties("car") 
    @JsonIgnore
    private List<Rent> rents;
      
    @Column(name = "car_type", nullable = false)
    private String carType;
    
    @Column(name = "age", nullable = false )
    private Integer age;
    
    @Column(name = "distance", nullable = false)
    private Integer distance;
    
    @Column(name = "price_hour", nullable = false)
    private Integer pricePerHour;
    
    @Column(name = "available", nullable = false)
    private Character available;
    
    
    
    
}
