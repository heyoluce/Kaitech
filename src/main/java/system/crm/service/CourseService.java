package system.crm.service;

import system.crm.web.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto getById(Long id);
    CourseDto create(CourseDto courseDto);
    List<CourseDto> getAllCourses();
}
