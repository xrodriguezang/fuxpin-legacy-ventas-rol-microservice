package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.RoleLegacy;

public interface RolesController {

    @RequestMapping("/getRoles/{id}")
    ResponseEntity<RoleLegacy> getRoles(Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/getRole")
    String getRole();

    @GetMapping("/getRoli/{id}")
    public ResponseEntity<?> getRoli(@PathVariable String id);

}