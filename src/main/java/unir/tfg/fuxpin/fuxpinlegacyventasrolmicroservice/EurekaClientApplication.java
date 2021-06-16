package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.LegacyRole;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.RegisteredUser;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.Alive;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.rest.Role;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services.ITestService;
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
 * Rest Controller provides the roles and infomation of the service registered
 */

@RestController
@Log4j2
class ServiceInstanceRestController implements RolesController {

	@Autowired
	IUserService userService;

	@Autowired
	ITestService testService;

	/**
	 * Gets and rewrites the legacy role and parse it in the new object.
	 *
	 * Be careful! No alter any field of the method. It can cause problems with interface mapping
	 *
	 * @param id username
	 *
	 * @return the legacy role
	 */
	@Override
	public ResponseEntity<?> getRoles(String id) {

		List<Role> roles = new ArrayList<>();

		try {

			RegisteredUser user = userService.getUserByUsername(id);

			if ( user==null ) {
				log.info("No roles for user: {}, return empty array", id);

				return ResponseEntity.ok(roles);
			}

			for (LegacyRole legacyRole: user.getRoles()) {
				// Transform the legacy role to the new object role
				roles.add(new Role(legacyRole.getCode(), legacyRole.getDescription()));
			}

		} catch (Exception e) {
			log.error("Problems with getRoles for user: {}", id, e);
		}

		return ResponseEntity.ok(roles);
	}

	/**
	 * Return is the components of the service are alive
	 *
	 * @return
	 */
	@Override
	public ResponseEntity<?> imAlive() {

		try {
			
			Alive alive = new Alive(testService.findAll() > 0 ? "OK" : "Problems with database", "OK");

			return ResponseEntity.ok(alive);

		} catch (Exception e) {
			log.error ("Problems with microservice health!", e);
		}

		return ResponseEntity.ok(new Alive("NOK", "NOK"));

	}

}