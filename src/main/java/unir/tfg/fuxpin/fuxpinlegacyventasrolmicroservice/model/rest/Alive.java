package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * To monitor de Eureka-service
 *
 * @author <a href="mailto:amgrill@gmail.com">Xavier Rodríguez</a>
 *
 */
@Getter @Setter @AllArgsConstructor
public class Alive {

    String appAlive;
    String databaseAlive;
}
