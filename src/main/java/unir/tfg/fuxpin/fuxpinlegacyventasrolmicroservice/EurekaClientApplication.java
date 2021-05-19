package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.LegacyRole;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.Alive;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.Role;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring boot application
 *
 * @author Xavier Rodríguez
 */
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

/**
 * Rest Controller that serves the role information
 */

@RestController
class ServiceInstanceRestController implements RolesController {

	Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);

	@Autowired
	IUserService userService;

	@Override
	public ResponseEntity<?> getRoles(String id) {

		List<Role> roles = new ArrayList<>();

		logger.info("Get roles by user: {}", id);

		RegisteredUser user = userService.getUserByUsername(id);

		logger.info("Legacy user: Returner: {}", user.toString());

		for (LegacyRole legacyRole: user.getRoles()) {
			// Transform the legacy role to the new object role
			roles.add(new Role(user.getRoles().get(0).getCode(), user.getRoles().get(0).getDescription()));
		}

		return ResponseEntity.ok(roles);
	}

	@Override
	public ResponseEntity<?> imAlive() {
		Alive alive = new Alive("Ok", "Ok");

		return ResponseEntity.ok(alive);
	}

}