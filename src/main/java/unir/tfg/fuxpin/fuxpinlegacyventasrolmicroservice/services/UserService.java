package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * User Service
 *
 * @author Xavier Rodríguez
 *
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<RegisteredUser> findAll() {
        List<RegisteredUser> userList = (List<RegisteredUser>) userRepository.findAll();

        return userList;
    }

    @Override
    public RegisteredUser getUser(String userId) {
        Optional<RegisteredUser> user = userRepository.findById(Long.getLong("1"));

        return user.get();
    }

    @Override
    public RegisteredUser getUserByUsername(String userId) {
        List<RegisteredUser> sss = (List<RegisteredUser>) userRepository.findAll();


        RegisteredUser user = userRepository.readRegisteredUserByUserName(userId);

        return user;
    }


}
