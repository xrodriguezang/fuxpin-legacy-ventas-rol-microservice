package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.Alive;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.RoleLegacy;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services.IUserService;

import java.util.List;

@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

@RestController
class ServiceInstanceRestController implements RolesController {

	Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);

	@Autowired
	IUserService userService;

	@Override
	public ResponseEntity<?> getRoles(String id) {

		logger.info("Get roles by user: {}", id);

		//List<RegisteredUser> registeredUserList = userService.findAll();

		RegisteredUser user = userService.getUserByUsername(id);

		logger.info("user Returner: {}", user.toString());

		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMINNNN");

		return ResponseEntity.ok(rolesLegacy);
	}


	@Override
	public ResponseEntity<?> imAlive() {
		Alive alive = new Alive("Ok", "Ok");

		return ResponseEntity.ok(alive);
	}

}