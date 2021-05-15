package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.RoleLegacy;

import java.util.List;

@SpringBootApplication
public class FuxpinLegacyVentasRolMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuxpinLegacyVentasRolMicroserviceApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@GetMapping("/getroles/{id}")
	public ResponseEntity<RoleLegacy> read(@PathVariable("id") Long id) {
		// https://www.baeldung.com/spring-boot-json

		RoleLegacy rolesLegacy = new RoleLegacy("1", "ROLE_ADMIN");

		rolesLegacy.setRoleId("222");

		return ResponseEntity.ok(rolesLegacy);
	}

}
