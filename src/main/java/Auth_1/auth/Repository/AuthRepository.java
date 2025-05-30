package Auth_1.auth.Repository;


import Auth_1.auth.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
