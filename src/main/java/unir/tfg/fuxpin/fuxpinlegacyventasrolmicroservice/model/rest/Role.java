package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * Role Object for Rest
 *
 * It's the new object Role defined for the new application
 *
 * @author Xavier Rodríguez
 *
 */

@Getter @Setter @AllArgsConstructor
public class Role {

    String roleId;
    String roleDescription;

}
