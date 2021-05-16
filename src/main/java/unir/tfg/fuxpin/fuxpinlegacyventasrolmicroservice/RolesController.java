package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Class with model Richardson
 */
public interface RolesController {

    @GetMapping("/imAlive")
    ResponseEntity<?> imAlive();

    @GetMapping("/getRoles/{id}")
    ResponseEntity<?> getRoles(@PathVariable String id);

}