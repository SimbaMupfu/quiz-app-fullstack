package inc.sims.hustles.controllers;

import inc.sims.hustles.dto.TestDTO;
import inc.sims.hustles.services.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/create-test")
    public ResponseEntity<?> createTest(@RequestBody TestDTO dto){
        try{
            return new ResponseEntity<>(testService.createTest(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
