package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.Alive;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.RoleLegacy;

@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

@RestController
class ServiceInstanceRestController implements RolesController {

	@Override
	public ResponseEntity<?> getRoles(String id) {

		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMIN");

		return ResponseEntity.ok(rolesLegacy);
	}


	@Override
	public ResponseEntity<?> imAlive() {
		Alive alive = new Alive("Ok", "Ok");

		return ResponseEntity.ok(alive);
	}

}