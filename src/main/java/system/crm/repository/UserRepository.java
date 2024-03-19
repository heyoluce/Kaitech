package system.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.crm.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
