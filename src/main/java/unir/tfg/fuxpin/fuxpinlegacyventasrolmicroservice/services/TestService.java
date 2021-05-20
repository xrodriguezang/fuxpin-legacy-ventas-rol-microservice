package unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.model.database.Test;
import unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.repository.TestRepository;

import java.util.List;

@Service
public class TestService implements ITestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    TestRepository testRepository;

    /**
     * Get connection and return if it is alive
     * @return
     */
    @Override
    public int findAll() {
        try {
            List<Test> userList = (List<Test>) testRepository.findAll();

            return userList.size();
        } catch (Exception e) {
            logger.error("Problems with database!", e);
        }
        return 0;
    }

}
