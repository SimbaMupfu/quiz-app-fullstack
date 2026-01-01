package inc.sims.hustles.services.user;

import inc.sims.hustles.enums.UserRole;
import inc.sims.hustles.models.User;
import inc.sims.hustles.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser(){
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);

        if(optionalUser == null){
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@hustles.com");
            user.setPassword("admin");
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        }
    }

    public boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }

    public User createUser(User user){
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    public User login(User user){
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())){
            return optionalUser.get();
        }
        return null;
    }
}
