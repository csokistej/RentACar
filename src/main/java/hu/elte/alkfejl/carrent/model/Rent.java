/**
 *
 * @author kgergely
 */
package hu.elte.alkfejl.carrent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rent extends BaseEntity{
    
    @JoinColumn
    @OneToOne(targetEntity = User.class, optional = false)
    @JsonIgnoreProperties("rents") //ToDo I don't know what is this exactly!!
    private User user;
    
    @JoinColumn
    @OneToOne(targetEntity = Car.class, optional = false)
    @JsonIgnoreProperties("rents") //ToDo I don't know what is this exactly!!
    private Car car;
    
    @Column(nullable = false)
    private Timestamp startDate;
    
    @Column(nullable = false)
    private Timestamp endDate;
    
    @Column(nullable = false)
    private int rentalCode;
    
    @Column(nullable = false)
    private RentalStatus status;
}
