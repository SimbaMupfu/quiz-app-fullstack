package inc.sims.hustles.controllers;

import inc.sims.hustles.models.User;
import inc.sims.hustles.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody User user){
        if(userService.hasUserWithEmail(user.getEmail())){
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        User newUser = userService.createUser(user);
        if(newUser == null){
            return new ResponseEntity<>("User not created. Please try again.", HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User dbUser = userService.login(user);
        if(dbUser == null){
            return new ResponseEntity<>("Wrong credentials", HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(dbUser, HttpStatus.OK);
        }
    }
}
