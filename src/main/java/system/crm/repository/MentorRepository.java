package system.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.crm.domain.entity.Mentor;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByUsername(String username);
}
