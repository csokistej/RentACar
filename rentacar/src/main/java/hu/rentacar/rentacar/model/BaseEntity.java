/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rentacar.rentacar.model;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author szotyi
 */


@Data
@MappedSuperclass
public class BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private long version;
   
    
}
