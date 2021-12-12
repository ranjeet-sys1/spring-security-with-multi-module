package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.model.Customer;
import security.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Customer customer = customerRepository.findByEmail(username);
        if(customer==null){
            throw new UsernameNotFoundException("user not found by this username : "+username);
        }
        UserDetails userDetails = User.withUsername(customer.getEmail()).password(customer.getPwd()).authorities(customer.getRole()).build();
        return userDetails;
    }
}
