
package hu.rentacar.rentacar.annotation;

import hu.rentacar.rentacar.model.Customer;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Role {
    Customer.Role[] value() default { Customer.Role.GUEST };
}
