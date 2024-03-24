package system.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.crm.domain.entity.Course;
import system.crm.domain.exception.ResourceNotFoundException;
import system.crm.repository.CourseRepository;
import system.crm.service.CourseService;
import system.crm.web.dto.CourseDto;
import system.crm.web.mappers.CourseMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));
    }

    @Override
    public Course create(Course course) {
        courseRepository.save(course);
        return course;
    }


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
