package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services;


import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;

import java.util.List;

/**
 *
 * User interface
 *
 * @author Xavier Rodríguez
 *
 */
public interface IUserService {

    List<RegisteredUser> findAll();

    RegisteredUser getUserByUsername(String userId);

}
