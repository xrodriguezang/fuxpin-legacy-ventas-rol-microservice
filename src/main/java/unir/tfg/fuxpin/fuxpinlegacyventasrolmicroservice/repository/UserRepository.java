package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.repository;


import org.springframework.data.repository.CrudRepository;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;

/**
 *
 * This interface provides the contract methods.
 *
 * Filter the CRUD methods.
 *
 * @author <a href="mailto:amgrill@gmail.com">Xavier Rodríguez</a>
 *
 */
public interface UserRepository extends CrudRepository<RegisteredUser, Long> {

    RegisteredUser readRegisteredUserByUserName (String userName);

}
