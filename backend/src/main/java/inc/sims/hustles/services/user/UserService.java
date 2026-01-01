package inc.sims.hustles.services.user;

import inc.sims.hustles.models.User;

public interface UserService {

    User createUser(User user);
    boolean hasUserWithEmail(String email);
    User login(User user);
}
