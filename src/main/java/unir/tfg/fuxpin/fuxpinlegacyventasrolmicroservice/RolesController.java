package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Microservice Interface
 *
 * It's a contract interface with de clients. It's the pipeline with the productor - consumers
 *
 * @author Xavier Rodríguez
 *
 * Model Richardson compliance
 */
public interface RolesController {

    /**
     * Method that send information about the microservice
     *
     * @return
     */
    @GetMapping("/imAlive")
    ResponseEntity<?> imAlive();

    /**
     * Return the legacy roles
     *
     * @param id username
     *
     * @return
     */
    @GetMapping("/getRoles/{id}")
    ResponseEntity<?> getRoles(@PathVariable String id);

}