package inc.sims.hustles.repositories;

import inc.sims.hustles.enums.UserRole;
import inc.sims.hustles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(UserRole userRole);

    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);
}
