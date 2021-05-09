package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.RoleLegacy;

@SpringBootApplication
@RestController
public class FuxpinLegacyVentasRolMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuxpinLegacyVentasRolMicroserviceApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/getroles/{id}")
	public ResponseEntity<RoleLegacy> read(@PathVariable("id") Long id) {
		// https://www.baeldung.com/spring-boot-json

		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMIN");

		rolesLegacy.setRoleId("222");

		return ResponseEntity.ok(rolesLegacy);
	}

}
