
package hu.rentacar.rentacar.config;

import hu.rentacar.rentacar.annotation.Role;
import hu.rentacar.rentacar.model.Customer;
import hu.rentacar.rentacar.service.CustomerService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        List<Customer.Role> routeRoles = getRoles((HandlerMethod) handler);
        Customer user = customerService.getCustomer();
        
        // when there are no restrictions, we let the user through
        if (routeRoles.isEmpty() || routeRoles.contains(Customer.Role.GUEST)) {
            return true;
        }
        // check role
        if (customerService.isLoggedIn() && routeRoles.contains(user.getRole())) {
            return true;
        }
        response.setStatus(401);
        return false;
    }
    private List<Customer.Role> getRoles(HandlerMethod handler) {
        Role role = handler.getMethodAnnotation(Role.class);
        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
    }
}
