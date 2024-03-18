package system.crm.service;

import system.crm.domain.entity.Course;

import java.util.List;

public interface CourseService {
    Course findById(Long id);
    List<Course> findAllByCourseName(String courseName);

}
