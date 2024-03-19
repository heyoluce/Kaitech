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

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto getById(Long id) {
        return null;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        if (allCourses.isEmpty()) throw new ResourceNotFoundException("The list of courses is empty.");
        else return courseMapper.toDto(allCourses);
    }

    @Override
    public CourseDto create(CourseDto courseDto) {
        Course createdCourse = courseMapper.toEntity(courseDto);
        courseRepository.save(createdCourse);
        return courseMapper.toDto(createdCourse);
    }
}
