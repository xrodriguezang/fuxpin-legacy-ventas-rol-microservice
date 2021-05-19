package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services;


import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;

import java.util.List;

/**
 *
 * To monitor de Eureka-service
 *
 * @author Xavier Rodríguez
 *
 */
public interface IUserService {

    List<RegisteredUser> findAll();

    RegisteredUser getUser(String userId);

    RegisteredUser getUserByUsername(String userId);

}
