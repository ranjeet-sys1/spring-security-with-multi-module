package security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByEmail(String email);
}
