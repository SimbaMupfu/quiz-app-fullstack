package inc.sims.hustles.services.user;

import inc.sims.hustles.enums.UserRole;
import inc.sims.hustles.models.User;
import inc.sims.hustles.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);

        if(optionalUser == null){
            User user = new User();
            user.setName("Name");
            user.setEmail("admin@hustles.com");
            user.setPassword("password");
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        }
    }

    public boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }
}
