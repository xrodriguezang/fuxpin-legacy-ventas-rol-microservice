package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.Test;

public interface TestRepository extends CrudRepository<Test, Long> {
}
