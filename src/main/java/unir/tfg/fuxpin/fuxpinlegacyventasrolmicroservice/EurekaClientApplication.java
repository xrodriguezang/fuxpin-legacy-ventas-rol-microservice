package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.RoleLegacy;

@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}

@RestController
class ServiceInstanceRestController implements RolesController {

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public ResponseEntity<RoleLegacy> getRoles(Long id) {
		// https://www.baeldung.com/spring-boot-json

		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMIN_" + appName);

		rolesLegacy.setRoleId("222");

		return ResponseEntity.ok(rolesLegacy);
	}

	@Override
	public String getRole() {
		// https://www.baeldung.com/spring-boot-json

		return "pepitu";
	}

	@Override
	public ResponseEntity<?> getRoli(String id) {
		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMIN_" + appName);

		rolesLegacy.setRoleId("222");

		return ResponseEntity.ok(rolesLegacy);
	}


}