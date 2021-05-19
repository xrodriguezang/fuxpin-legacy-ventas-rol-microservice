package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.repository;


import org.springframework.data.repository.CrudRepository;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;

/**
 *
 * This interface provides the contract methods.
 *
 * Filter the CRUD methods.
 *
 * @author Xavier Rodríguez
 *
 */
public interface UserRepository extends CrudRepository<RegisteredUser, Long> {

    // Spring Date uses PropertyPath method to extract path to a property for a predicate constructed from method.
    // it's magically injected the implementation.
    // More info: https://spring.io/projects/spring-data-jpa
    RegisteredUser readRegisteredUserByUserName (String userName);

}
