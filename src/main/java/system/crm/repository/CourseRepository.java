package system.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.crm.domain.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
    List<Course> findAllByCourseName(String courseName);
}
