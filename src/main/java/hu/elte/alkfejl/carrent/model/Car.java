/**
 *
 * @author kgergely
 */
package hu.elte.alkfejl.carrent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car  extends BaseEntity{
    
    @Column(nullable = false)
    private String carType;
    
    @Column(nullable = false)
    private int age;
    
    @Column(nullable = false)
    private int distance;
    
    @Column(nullable = false)
    private int priceHour;
    
    @Column(nullable = false)
    private boolean available;
}
