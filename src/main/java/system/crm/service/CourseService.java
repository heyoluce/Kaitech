package system.crm.service;

import system.crm.domain.entity.Course;
import system.crm.web.dto.CourseDto;

import java.util.List;

public interface CourseService {
    Course getById(Long id);
    Course create(Course course);
    List<Course> getAllCourses();
}
