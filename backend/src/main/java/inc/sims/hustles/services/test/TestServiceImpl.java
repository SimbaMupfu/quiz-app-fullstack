package inc.sims.hustles.services.test;

import inc.sims.hustles.dto.TestDTO;
import inc.sims.hustles.models.Test;
import inc.sims.hustles.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {

    @Autowired
    private TestRepository testRepository;

    public TestDTO createTest(TestDTO dto){
        Test test = new Test();
        test.setTitle(dto.getTitle());
        test.setDescription(dto.getDescription());
        test.setTime(dto.getTime());

        return testRepository.save(test).getDto();
    }
}
