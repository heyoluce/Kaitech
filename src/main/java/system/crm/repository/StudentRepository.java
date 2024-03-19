package system.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.crm.domain.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);
    void deleteByUsername(String username);
}
